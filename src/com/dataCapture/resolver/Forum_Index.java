package com.dataCapture.resolver;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.bean.ForumBean;
import com.dataCapture.util.DateUtil;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.uploadImgData.ImgUtil;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月15日
 *
 * @TIME 下午12:06:16
 */
public class Forum_Index {

	private static Element ul;
	private static Elements li;

	public static List<ForumBean> ForumIndex(String html) {
		Document document = Jsoup.parse(html);

		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			ul = document.select("div#search-results>ul.list-unstyled.search-result-view.clearfix").get(0);
			li = ul.select("li.col-xs-12.col-sm-12.col-md-12.col-lg-12");
			break;
		case 2:
			ul = document.select("ul.list-unstyled.search-result-view.clearfix.m-bottom-1").get(0);
			li = ul.children();
			break;
		case 1:
			ul = document.select("ul.list-unstyled.search-result-view.clearfix.m-bottom-1").get(0);
			li = ul.children();
			break;
		default:
			break;
		}

		List<ForumBean> forumBeans = new ArrayList<>();

		WebSiteConfig.setTotalSize(li.size());
		for (Element item : li) {
			ForumBean bean = new ForumBean();

			// 每个帖子的详情页面
			String url = null;
			switch (WebSiteConfig.WEB_SITE) {
			case 3:
				url = item.select("article.media>div.media-body.media-full>p.text-muted>a").get(0).attr("href");
				break;
			case 2:
				url = item.select("h4.h4.m-top-0>a").get(0).attr("href");
				break;
			case 1:
				url = item.select("h4.h4.m-top-0>a").get(0).attr("href");
				break;
			default:
				break;
			}
			bean.setForumUrl(url);

			// 查看次数
			String viewNum = null;
			String likeNum=null;
			String commonNum=null;
			switch (WebSiteConfig.WEB_SITE) {
			case 3:
				viewNum = item.select("i.ss-icon.ss-gizmo.ss-view").next("span").text();
				// like数量
				likeNum = item.select("i.ss-icon.ss-gizmo.ss-heart").next("span").text();
				//评论
				commonNum=item.select("i.ss-icon.ss-gizmo.ss-chat").next("span").text();
				
				break;
			case 2:
				viewNum = item.select("i.ss-pika.ss-view").next("span").text();
				// like数量
				likeNum = item.select("i.ss-pika.ss-heart").next("span").text();
				//评论
				commonNum=item.select("i.ss-pika.ss-chat").next("span").text();
				break;
			case 1:
				viewNum = item.select("i.ss-pika.ss-view").next("span").text();
				// like数量
				likeNum = item.select("i.ss-pika.ss-heart").next("span").text();
				//评论
				commonNum=item.select("i.ss-pika.ss-chat").next("span").text();
				
				break;
			default:
				break;
			}
			if (viewNum!=null&&!"".equals(viewNum)) {
				bean.setViewNum(Integer.parseInt(viewNum));
			}
			if (likeNum!=null&&!"".equals(likeNum)) {
				bean.setLoveNum(Integer.parseInt(likeNum));
			}
			if (commonNum!=null&&!"".equals(commonNum)) {
				bean.setCommonNum(Integer.parseInt(commonNum));
			}


		

			forumBeans.add(bean);
		}

		return forumBeans;
	}

	// 获取详情
	public static void forum_info(String html, ForumBean bean) {
		Document document = Jsoup.parse(html);

		// 设置标题
		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			String title = document.select("article.container.main-content>div.row>header>h2.h2").get(0).text();
			bean.setTitle(title);
			break;
		case 2:

			bean.setTitle(document.select("div.content-title.clearfix>h2.h2").get(0).text());
			break;
		case 1:

			bean.setTitle(document.select("div.content-title.clearfix>h2.h2").get(0).text());
			break;
		}

		// 设置创建人uuid
		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			String createUser = document
					.select("article.container.main-content>div.row>header>div.media>section.media-body.media-full.media-middle"
							+ ">strong>a.modal-dialog-link.btn-link.btn-link-primary")
					.get(0).attr("href");
			bean.setCreateUserId(createUser.substring(createUser.lastIndexOf("/") + 1, createUser.length()));
			break;
		case 2:
			String createUser1 = document.select("a.modal-dialog-link.btn-link.btn-link-primary").get(0).attr("href");
			bean.setCreateUserId(createUser1.substring(createUser1.lastIndexOf("/") + 1, createUser1.length()));
			break;
		case 1:
			String createUser2 = document.select("a.modal-dialog-link.btn-link.btn-link-primary").get(0).attr("href");
			bean.setCreateUserId(createUser2.substring(createUser2.lastIndexOf("/") + 1, createUser2.length()));
			break;
		}

		// 设置帖子正文
		String body = null;
		int bodyIndex;
		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			body = document
					.select("article.container.main-content>div.row>section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2"
							+ ">section.submission-content.cms.m-bottom-2")
					.html();
			break;
		case 2:
			body = document.select("div.card-block.activity-response>*:not(.featured-image-carousel)").toString();
			bodyIndex = body.lastIndexOf("<ul class");
			body = body.substring(0, bodyIndex > 0 ? bodyIndex : body.length());
			
			break;
		case 1:
			body = document.select("div.card-block.activity-response>*").toString();
			bodyIndex = body.lastIndexOf("<ul class");
			body = body.substring(0, bodyIndex > 0 ? bodyIndex : body.length());
		default:
			break;
		}
		bean.setBody(body);

		/*
		 * 下载图片
		 */

		bean.setBody(ImgUtil.uploadBodyImg(bean.getBody(), bean.getForumUrl(), WebSiteConfig.WEB_MODULE));

		if (WebSiteConfig.WEB_SITE == 3) {

			// 创建时间
			String date = document
					.select("article.container.main-content>div.row>header>div.media>section.media-body.media-full.media-middle"
							+ ">p.text-muted>time.timeago")
					.attr("datetime");
			bean.setCreateDateTime(DateUtil.parseDateByString(date));

			// tag
			Elements tags = document
					.select("article.container.main-content>div.row>section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2"
							+ ">ul.tag-list.list-unstyled>li.tag");
			StringBuffer stringBuffer = new StringBuffer();
			for (Element tag : tags) {
				stringBuffer.append(tag.select("a").text() + ",");
			}
			String tagstring = stringBuffer.toString();
			if (tagstring != null && !"".equals(tagstring)) {
				tagstring = tagstring.substring(0, tagstring.length() - 1);
			}
			bean.setTag(tagstring);

			// 帖子图片
			Elements imgs = document
					.select("ul.m-bottom-2.list-inline>li");
			if (imgs!=null&&!imgs.isEmpty()) {
				
				StringBuffer sbBuffer = new StringBuffer();
				for (Element img : imgs) {
					sbBuffer.append(img.select("a>img").attr("src") + ",");
				}
				String imgString = sbBuffer.toString();
				if (imgString != null && !("").equals(imgString)) {
					imgString = imgString.substring(0, imgString.length() - 1);
				}
				bean.setImageUrl(imgString);
				/*
				 * 下载图片
				 */
				
				bean.setImageUrl(ImgUtil.upImg(bean.getFeaturedImageUrl(), bean.getForumUrl(), WebSiteConfig.WEB_MODULE));
			}

			// 帖子uuid
			int index = html.indexOf("votingTargetId");
			String com = html.substring(index + 17);
			int end = com.indexOf("\",");
			String uuid = com.substring(0, end);
			if (uuid != null && !"".equals(uuid) && uuid.length() < 60) {

				bean.setUUID(com.substring(0, end));
			} else {
				index = html.indexOf("submissionUrl");
				com = html.substring(index);
				end = com.indexOf("response/");
				String com1 = com.substring(end + 9);
				uuid = com1.substring(0, com1.indexOf("\""));
				bean.setUUID(uuid);
			}

			// 设置评论的url
			bean.setCommonUrl(UrlConfig.getObserverUrl(bean.getUUID(), "250"));
		} else {
			// 创建时间
			String date = document.select("time.timeago").attr("datetime");
			bean.setCreateDateTime(DateUtil.parseDateByString(date));

			// tag
			Elements tags = document.select("ul.tag-list.list-unstyled>li.tag");
			StringBuffer stringBuffer = new StringBuffer();
			for (Element tag : tags) {
				stringBuffer.append(tag.select("a").text() + ",");
			}
			String tagstring = stringBuffer.toString();
			if (tagstring != null && !"".equals(tagstring)) {
				tagstring = tagstring.substring(0, tagstring.length() - 1);
			}
			bean.setTag(tagstring);

			// 帖子图片
			Elements imgs = document.select("div.slide.js-slide");
			StringBuffer sbBuffer = new StringBuffer();
			for (Element img : imgs) {
				String src = img.select("img").attr("src");
				if (src != null && !"".equals(src)) {

					sbBuffer.append(img.select("img").attr("src") + ",");
				} else {
					sbBuffer.append(img.select("img").attr("data-src") + ",");
				}
			}
			String imgString = sbBuffer.toString();
			if (imgString != null && !("").equals(imgString)) {
				imgString = imgString.substring(0, imgString.length() - 1);
			}
			bean.setImageUrl(imgString);
			/*
			 * 下载图片
			 */

			if (bean.getImageUrl() != null) {

				bean.setImageUrl(ImgUtil.upImg(bean.getImageUrl(), bean.getForumUrl(), WebSiteConfig.WEB_MODULE));
			}

			// 帖子uuid
			int index = html.indexOf("votingTargetId");
			String com = html.substring(index + 17);
			int end = com.indexOf("\",");
			String uuid = com.substring(0, end);
			if (uuid != null && !"".equals(uuid) && uuid.length() < 60) {

				bean.setUUID(com.substring(0, end));
			} else {
				index = html.indexOf("submissionUrl");
				com = html.substring(index);
				end = com.indexOf("response/");
				String com1 = com.substring(end + 9);
				uuid = com1.substring(0, com1.indexOf("\""));
				bean.setUUID(uuid);
			}

			// 设置评论的url
			bean.setCommonUrl(UrlConfig.getObserverUrl(bean.getUUID(), "250"));

		}

	}

}
