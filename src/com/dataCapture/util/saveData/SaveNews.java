package com.dataCapture.util.saveData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.NewsBean;
import com.dataCapture.model.Results;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.Tags;
import com.dataCapture.reflectTest.CopyObject;
import com.dataCapture.resolver.News_Index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
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
 * @DATE 2018年1月12日
 *
 * @TIME 上午9:56:12
 */

public class SaveNews {

	private DataCaptureService service;
	private CommonService commonService;
	private TagService tagService;

	public SaveNews(DataCaptureService service, CommonService commonService, TagService tagService) {
		this.commonService = commonService;
		this.service = service;
		this.tagService = tagService;
	}

	public void saveNews(final List<NewsBean> infos) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (NewsBean bean : infos) {

					String html = null;

					try {
						// 获取单个详情页的html
						html = HtmlUtil.getHtml(bean.getNewsUrl());
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();Progress.error=true;
					}
					// 获取详情数据
					try {
						News_Index.News_Info(html, bean);
					} catch (FailingHttpStatusCodeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();Progress.error=true;
					}

					// 评论存库
					try {
						saveCommons(bean);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();Progress.error=true;
					}
					// tag存库
					saveTag(bean);
					
				

					// 反射把bean转成pojo
					News news = (News) CopyObject.copy(bean, new News());

					// 存入数据库
					service.save(news);
					System.out.println(news);
					
                    Progress.Progressing();
				}
			}
		}).start();
	}

	private void saveCommons(NewsBean newsBean){

		String observer_url = newsBean.getCommonUrl();

		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(observer_url);
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
				common.setType(1);
				if (WebSiteConfig.WEB_MODULE==WebModule.TRAINING) {
					common.setType(2);
				}
				//设置评论like
				common.setLoveNum(bean.getUser_vote().getSum());
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(newsBean.getUUID());
				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, newsBean.getNewsUrl(),WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());

				int replyCount = bean.getReplies_count_descendants();
				if (replyCount > 0) {
					System.err.println("此处有回复!");
					newsBean.setReplyUrl(UrlConfig.getReplyUrl(newsBean.getUUID(), common.getUUID(), 250));
					if (WebSiteConfig.WEB_SITE==2||WebSiteConfig.WEB_SITE==1) {
						newsBean.setReplyUrl(UrlConfig.getReplyUrl(newsBean.getUUID(), bean.getThread_uuid(), 250));
					}
					// 回复入库
					try {
						saveReply(newsBean);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();Progress.error=true;
					}
				}

				// 存入评论
				commonService.save(common);
				// System.out.println(common);
			}
		}

	}

	private void saveTag(NewsBean bean) {
		String tagString = bean.getTag();

		if (tagString != null && !"".equals(tagString)) {
			String[] tags = tagString.split(",");
			for (int i = 0; i < tags.length; i++) {
				Tags t = new Tags();
				t.setCreateDateTime(bean.getCreateDateTime());
				t.setIsDeleted(false);
				t.setModuleId(bean.getUUID());
				t.setName(tags[i]);
				t.setTagGype(5);
				if (WebSiteConfig.WEB_MODULE==WebModule.TRAINING) {
					t.setTagGype(6);
				}
				t.setWebsiteName(bean.getWebsiteName());
				t.setUUID(UUID.randomUUID().toString());

				//存库
				 tagService.save(t);
				System.out.println(t);
			}

		}
	}
	
	private void saveReply(NewsBean newsBean){
		//获取json
		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(newsBean.getReplyUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();Progress.error=true;
		}
		
		if (commonJson!=null&&commonJson.indexOf("\"results\":")>0) {
			List<Results> commons=JSON.parseArray(UrlConfig.getJson(commonJson),Results.class);
			
			for (Results bean : commons) {
				Common common=new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(DateUtil.parseDateByLong(bean.getCreated_at()));
				common.setType(1);
				if (WebSiteConfig.WEB_MODULE==WebModule.TRAINING) {
					common.setType(2);
				}
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(bean.getIn_reply_to().getId());
				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				//设置评论like
				common.setLoveNum(bean.getUser_vote().getSum());
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, newsBean.getNewsUrl(),WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());
                common.setReplyId(newsBean.getUUID());
				
				//存库
				commonService.save(common);
                System.err.println(common);
			}
			
		}
	}
}