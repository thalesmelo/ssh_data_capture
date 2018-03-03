package com.dataCapture.util.saveData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.PhotoBean;
import com.dataCapture.model.Results;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.pojo.Tags;
import com.dataCapture.reflectTest.CopyObject;
import com.dataCapture.resolver.Album_index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.PhotoService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.DateUtil;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.Progress;
import com.dataCapture.util.StringConfig;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.uploadImgData.ImgUtil;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:35:43
 */
public class SavePhotos {

	private PhotoService photoService;
	private CommonService commonService;
	private TagService tagService;

	public SavePhotos(PhotoService photoService, CommonService commonService, TagService tagService) {
		this.commonService = commonService;
		this.photoService = photoService;
		this.tagService = tagService;
	}

	public void save(List<PhotoBean> beans){

		for (PhotoBean bean : beans) {

			try {
				// 获取图片的详情
				Album_index.photoInfo(bean);
			} catch (FailingHttpStatusCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();Progress.error=true;
			}

			// tag存库
			String tagString = bean.getTags();
			if (tagString != null && !"".equals(tagString)) {
				String[] taglsit = tagString.split(",");
				for (String string : taglsit) {
					Tags tags = new Tags();
					tags.setCreateDateTime(bean.getCreateDateTime());
					tags.setModuleId(bean.getUUID());
					tags.setName(string);
					tags.setTagGype(2);
					 tagService.save(tags);
					System.out.println(tags);
				}
			}

			// 评论存库
			try {
				saveCommon(bean);
			} catch (FailingHttpStatusCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();Progress.error=true;
			}

			// 把图片转为pojo存库
			PhotosImg photosImg = (PhotosImg) CopyObject.copy(bean, new PhotosImg());
			System.out.println(photosImg);
			 photoService.save(photosImg);
			 
		}

	}

	private void saveCommon(PhotoBean photoBean){

		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(photoBean.getCommonUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();Progress.error=true;
		}

		if (commonJson != null && commonJson.indexOf("\"results\":") > 0) {
			List<Results> commons = JSON.parseArray(UrlConfig.getJson(commonJson), Results.class);

			for (Results bean : commons) {
				Common common = new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(DateUtil.parseDateByLong(bean.getCreated_at()));

				common.setType(4);
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(photoBean.getUUID());
				//设置评论like
				common.setLoveNum(bean.getUser_vote().getSum());
				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, photoBean.getPhotoUrl(),WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());
				int replyCount = bean.getReplies_count_descendants();
				if (replyCount > 0) {
					photoBean.setReplyUrl(UrlConfig.getReplyUrl(photoBean.getUUID(), common.getUUID(), replyCount));
					if (WebSiteConfig.WEB_SITE == 2 || WebSiteConfig.WEB_SITE == 1) {
						photoBean.setReplyUrl(UrlConfig.getReplyUrl(photoBean.getUUID(), bean.getThread_uuid(), 250));
					}
					// 回复入库
					try {
						saveReply(photoBean);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();Progress.error=true;
					}
				}
				 commonService.save(common);
				System.err.println(common);
			}

		}
	}

	private void saveReply(PhotoBean photoBean) {
		// 获取json
		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(photoBean.getReplyUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();Progress.error=true;
		}

		if (commonJson != null && commonJson.indexOf("\"results\":") > 0) {
			List<Results> commons = JSON.parseArray(UrlConfig.getJson(commonJson), Results.class);

			for (Results bean : commons) {
				Common common = new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(DateUtil.parseDateByLong(bean.getCreated_at()));
				common.setType(4);
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(bean.getIn_reply_to().getId());
				//设置评论like
				common.setLoveNum(bean.getUser_vote().getSum());
				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, photoBean.getPhotoUrl(),WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());
				common.setReplyId(photoBean.getUUID());

				System.out.println("SaveForums.saveReply()" + common);
				 commonService.save(common);
			}

		}
	}
}
