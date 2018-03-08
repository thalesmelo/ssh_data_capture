package com.dataCapture.util.saveData;

import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.dataCapture.Enum.WebModule;
import com.dataCapture.activity.model.ActivityBean;
import com.dataCapture.bean.ForumBean;
import com.dataCapture.model.Results;
import com.dataCapture.pojo.ActivityModel;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.pojo.Post;
import com.dataCapture.pojo.Tags;
import com.dataCapture.reflectTest.CopyObject;
import com.dataCapture.resolver.Forum_Index;
import com.dataCapture.service.ActivityModelService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.ForumService;
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
 * @DATE 2018年1月15日
 *
 * @TIME 下午4:13:08
 */
public class SaveForums {

	private ForumService forumService;
	private CommonService commonService;
	private TagService tagService;
	private ActivityModelService activityModelService;
	private PhotoService photoService;

	public SaveForums(ForumService forumService, CommonService commonService, TagService tagService) {
		this.commonService = commonService;
		this.forumService = forumService;
		this.tagService = tagService;
	}

	public SaveForums(ForumService forumService, CommonService commonService, TagService tagService,
			ActivityModelService activityModelService, PhotoService photoService) {
		this.commonService = commonService;
		this.forumService = forumService;
		this.tagService = tagService;
		this.activityModelService = activityModelService;
		this.photoService = photoService;
	}

	public void save(final List<ForumBean> beans) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (ForumBean bean : beans) {
					// 帖子的详情页面html
					String itemHtml = null;

					try {
						itemHtml = HtmlUtil.getHtml(bean.getForumUrl());
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Progress.error = true;
					}

					Forum_Index.forum_info(itemHtml, bean);
					try {
						saveCommon(bean);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Progress.error = true;
					}
					String tagString = bean.getTag();
					if (tagString != null && !"".equals(tagString)) {
						String[] tags = tagString.split(",");
						for (int i = 0; i < tags.length; i++) {
							Tags t = new Tags();
							t.setCreateDateTime(bean.getCreateDateTime());
							t.setIsDeleted(false);
							t.setModuleId(bean.getUUID());
							t.setName(tags[i]);
							t.setTagGype(7);
							t.setWebsiteName(bean.getWebsiteName());
							t.setUUID(UUID.randomUUID().toString());

							tagService.save(t);
							System.out.println(t);
						}

					}
					// 通过反射把bean转为pojo
					Post post = (Post) CopyObject.copy(bean, new Post());
					System.out.println(bean);

					// 存库actmodel
					if (WebSiteConfig.WEB_MODULE == WebModule.ACTIVITY) {

						ActivityModel model=saveActModel(post);
						post.setBody(model.getBody());
					}

					forumService.save(post);
					Progress.Progressing();
				}
			}
		}).start();
	}

	public void saveCommon(ForumBean forumBean) {
		// 获取json
		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(forumBean.getCommonUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}

		if (commonJson != null && commonJson.indexOf("\"results\":") > 0) {
			List<Results> commons = JSON.parseArray(UrlConfig.getJson(commonJson), Results.class);

			for (Results bean : commons) {
				Common common = new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(DateUtil.parseDateByLong(bean.getCreated_at()));

				common.setType(0);
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(forumBean.getUUID());
				common.setActivityId(WebSiteConfig.Activity_UUID);
				//设置评论like数
				common.setLoveNum(bean.getUser_vote().getSum());

				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, forumBean.getForumUrl(), WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());
				int replyCount = bean.getReplies_count_descendants();
				if (replyCount > 0) {
					forumBean.setReplyUrl(UrlConfig.getReplyUrl(forumBean.getUUID(), common.getUUID(), replyCount));
					if (WebSiteConfig.WEB_SITE == 2 || WebSiteConfig.WEB_SITE == 1) {
						forumBean.setReplyUrl(UrlConfig.getReplyUrl(forumBean.getUUID(), bean.getThread_uuid(), 250));
					}
					// 回复入库
					try {
						saveReply(forumBean);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Progress.error = true;
					}
				}
				commonService.save(common);
				System.err.println(common);
			}

		}
	}

	public void saveReply(ForumBean forumBean) {
		// 获取json
		String commonJson = null;
		try {
			commonJson = HtmlUtil.getJsonHtml(forumBean.getReplyUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (commonJson != null && commonJson.indexOf("\"results\":") > 0) {
			List<Results> commons = JSON.parseArray(UrlConfig.getJson(commonJson), Results.class);

			for (Results bean : commons) {
				Common common = new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(DateUtil.parseDateByLong(bean.getCreated_at()));
				common.setType(0);
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(bean.getIn_reply_to().getId());
				common.setActivityId(WebSiteConfig.Activity_UUID);
				//设置评论like
				common.setLoveNum(bean.getUser_vote().getSum());
				common.setCreateDateTime(DateUtil.parseDateByLong(bean.getCreated_at()));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
					common.setImageUrl(ImgUtil.upImg(img, forumBean.getForumUrl(), WebModule.COMMENT));
				}
				common.setCreateUserUUID(bean.getAuthor_id());
				common.setReplyId(forumBean.getUUID());

				System.out.println("SaveForums.saveReply()" + common);
				commonService.save(common);
			}

		}
	}

	// 保存activity的post 分多种情况
	public ActivityModel saveActModel(Post post) {
		ActivityModel model = new ActivityModel();

		// activityModel的参数
	    ActivityBean.getActModel(post,model);
		
		
		model.setActivityUUID(post.getUUID());
		
		model.setCreateDateTime(post.getCreateDateTime());
	
		model.setImage(post.getImageUrl());
		model.setUserID(post.getCreateUserId());
        model.setTag(post.getTag());
		
		activityModelService.save(model);
		
		
		return model;
	}

	// 保存图片到相册 返回图片的uuids
	/*public String saveImg(Post post) {
		
		StringBuffer imgUUIDS=new StringBuffer();

		//图片数组
		String[] imgs=post.getImageUrl().split(",");
		for (String img : imgs) {
			PhotosImg photosImg=new PhotosImg();
			photosImg.setCreateDateTime(post.getCreateDateTime());
			photosImg.setDescription("");
			photosImg.setIds(post.getUUID());
			photosImg.setImg(img);
			photosImg.setUserid(post.getCreateUserId());
			photosImg.setUUID(UUID.randomUUID().toString());
			photosImg.setType(0);
			
			photoService.save(photosImg);
			imgUUIDS.append(photosImg.getUUID()+",");
		}
		
		String uuids=imgUUIDS.toString();
		if (uuids.length()>0) {
			uuids=uuids.substring(0,uuids.length()-1);
		}
		
		return uuids;
	}
*/
}
