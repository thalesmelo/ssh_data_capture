package com.dataCapture.resolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.NewsBean;
import com.dataCapture.pojo.News_info;
import com.dataCapture.util.DateUtil;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.StringConfig;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.uploadImgData.ImgUtil;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * @author zhuCan
 *
 * @DATE 2017年9月30日
 *
 * @TIME 上午9:10:01
 */
public class News_Index {

	/**
	 * @param args
	 * @throws IOException
	 */
	// 获取列表页面的数据
	public static List<NewsBean> getIndex(String html, String referer) {
		// TODO Auto-generated method stub

		// 获取html的节点
		Document document = null;
		document = Jsoup.parse(html);

		// 过滤节点信息,每条信息分成一个节点
		Element body = document.getElementById("blogs-blog");
		Elements items = body.select("article.container.main-content>ul.list-unstyled>li");
		if (WebSiteConfig.WEB_SITE == 1 || WebSiteConfig.WEB_SITE == 2) {
			items = body.select("article.main-content.row>ul.list-unstyled>li");
		}

		List<NewsBean> infos = new ArrayList<>();

		WebSiteConfig.setTotalSize(items.size());

		for (Element element : items) {

			// 把参数都转成数据对象
			NewsBean info = new NewsBean();

			// 获取图片的地址
			String img = element.select("img.img-responsive.m-bottom-2").attr("src");
			info.setFeaturedImageUrl(img);
			if (WebSiteConfig.WEB_MODULE == WebModule.TRAINING) {
				info.setFeaturedImageUrl(WebSiteConfig.Traning_Img_Url + img.substring(img.lastIndexOf("/") + 1));
			}
			info.setFeaturedImageUrl(ImgUtil.upImg(info.getFeaturedImageUrl(), referer, WebSiteConfig.WEB_MODULE));

			// 获取列表页的简介
			Elements content = element.select("article.card>div.row>article.col-xs-12>section.card-block.clearfix>"
					+ "section.blog-main.col-md-8.col-lg-9.col-sm-12>*:gt(2)");
			if (WebSiteConfig.WEB_SITE == 3) {
				content = element.select("article.card>div.row>article.col-xs-12>section.card-block.clearfix>"
						+ "section.blog-main.col-md-9.col-sm-12>*:gt(2)");
			}
			info.setTeaser(StringConfig.getNewsDisc(content.toString()).replace("<p>", "").replace("</p>", ""));

			// 获取详情页面的url
			String url = element.select("h1>a").attr("href");
			info.setNewsUrl(WebSiteConfig.Web_Url + url);

			if (WebSiteConfig.WEB_MODULE == WebModule.TRAINING) {
				int start = url.indexOf("blogs/");
				int end = url.lastIndexOf("-");
				int start1 = img.lastIndexOf("/");
				info.setFeaturedImageUrl(
						WebSiteConfig.COMMON_BODY_URL + url.substring(start, end) + img.substring(start1));
				
				info.setFeaturedImageUrl(ImgUtil.upImg(info.getFeaturedImageUrl(), referer, WebSiteConfig.WEB_MODULE));
				info.setNewsUrl(url);
			}

			infos.add(info);

		}

		return infos;
	}

	// 获取详情页面的数据
	public static void News_Info(String html, NewsBean info) {
		// 把html转换成docment
		Document document = Jsoup.parse(html);

		// 查看次数
		String viewNum = null;
		String likeNum = null;
		String commonNum = null;
		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			viewNum = document.select("i.ss-icon.ss-gizmo.ss-view").next("span").text();
			// like数量
			likeNum = document.select("i.ss-icon.ss-gizmo.ss-heart").next("span").text();
			// 评论
			commonNum = document.select("i.ss-icon.ss-gizmo.ss-chat").next("span").text();

			break;
		case 2:
			viewNum = document.select("i.ss-pika.ss-view").next("span").text();
			// like数量
			likeNum = document.select("i.ss-pika.ss-heart").next("span").text();
			// 评论
			commonNum = document.select("i.ss-pika.ss-chat").next("span").text();
			break;
		case 1:
			viewNum = document.select("i.ss-pika.ss-view").next("span").text();
			// like数量
			likeNum = document.select("i.ss-pika.ss-heart").next("span").text();
			// 评论
			commonNum = document.select("i.ss-pika.ss-chat").next("span").text();

			break;
		default:
			break;
		}
		if (viewNum != null && !"".equals(viewNum)) {
			if (viewNum.endsWith("k")) {
				info.setViewNum(1000);
			}else {
				
				info.setViewNum(Integer.parseInt(viewNum));
			}
		}
		if (likeNum != null && !"".equals(likeNum)) {
			info.setLoveNum(Integer.parseInt(likeNum));
		}
		if (commonNum != null && !"".equals(commonNum)) {
			info.setCommonNum(Integer.parseInt(commonNum));
		}

		if (WebSiteConfig.WEB_SITE == 3) {

			// 获取发表时间
			String time = document
					.select("article.card>div.card-block.clearfix>aside.blog-aside.col-md-4.col-sm-12.m-bottom-2>"
							+ "article.media>section.media-body.media-middle>span.text-muted>time")
					.get(0).attr("datetime");
			info.setCreateDateTime(DateUtil.parseDateByString(time));

			// 获取新闻标题
			Elements title = document.select("article .card >div >section>h2");
			info.setTitle(title.get(0).text());

			// 获取图片url
			Elements url = document
					.select("article.card >div.card-block.clearfix> section.blog-main.col-md-8.col-lg-9.col-sm-12>"
							+ "div.featured-container>div.featured-container-image>div[data-view=main]>div>"
							+ "img.img-responsive");
			if (WebSiteConfig.WEB_SITE == 3) {

				url = document.select("article.card >div.card-block.clearfix> section.blog-main.col-md-8.col-sm-12>"
						+ "img.m-bottom-2.img-responsive");
			}
			if (url.attr("src") != null && !"".equals(url.attr("src"))) {
				info.setImageUrl(url.attr("src"));
			} else {
				info.setImageUrl(url.attr("data-src"));
			}
			info.setImageUrl(ImgUtil.upImg(info.getImageUrl(), info.getNewsUrl(), WebSiteConfig.WEB_MODULE));

			// 获取内容下面的标签
			Elements laElements = document.select("article .card >div > section > section>ul.tag-list.list-inline>li");
			StringBuffer sBuffer = new StringBuffer();
			if (laElements != null) {
				for (Element element : laElements) {
					sBuffer.append(element.text() + ",");
				}
				String s1 = sBuffer.toString();
				if (s1.length() > 0) {
					s1 = s1.substring(0, s1.length() - 1);
				}
				info.setTag(s1);
			}

			// 获取新闻内容内容
			Elements contents = document.select(
					"article.card>div.card-block.clearfix>section.blog-main.col-md-8.col-lg-9.col-sm-12>*:gt(3)");

			if (WebSiteConfig.WEB_SITE == 3) {
				contents = document
						.select("article.card>div.card-block.clearfix>section.blog-main.col-md-8.col-sm-12>*:gt(3)");
			}
			info.setBody(StringConfig.getNewsBody(contents.toString()));
			info.setBody(ImgUtil.uploadBodyImg(info.getBody(), info.getNewsUrl(), WebSiteConfig.WEB_MODULE));

			// 设置新闻的uuid
			int index = html.indexOf("votingTargetId");
			String com = html.substring(index + 17);
			int end = com.indexOf("\",");

			info.setUUID(com.substring(0, end));

			// 设置用户作者的uuid
			String authorUrl = document
					.select("article.card>div.card-block.clearfix>aside.blog-aside.col-md-4.col-sm-12.m-bottom-2>"
							+ "article.media>a")
					.get(0).attr("href");

			String aString = WebSiteConfig.Web_Url + authorUrl + "/activity";

			String authorHtml = null;
			try {
				authorHtml = HtmlUtil.getHtml(aString);
			} catch (FailingHttpStatusCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Document document2 = Jsoup.parse(authorHtml);

			String idUrl = document2
					.select("body#profiles-profile-show-activity>header.profile-header.bg-pfa>div.container>"
							+ "div.row>div.col-lg-6.col-md-12.col-sm-12>article.media.header-profile-user-info.m-bottom-2>section.media-body.media-middle.media-full>"
							+ "h2>a.modal-dialog-link.btn-link.btn-link-primary")
					.attr("href");
			String uuid = idUrl.substring(idUrl.lastIndexOf("/") + 1, idUrl.length());

			info.setCreateUserId(uuid);

			// 设置评论的url
			info.setCommonUrl(UrlConfig.getObserverUrl(info.getUUID(), "250"));
		}

		if (WebSiteConfig.WEB_SITE == 1 || WebSiteConfig.WEB_SITE == 2) {
			// 获取发表时间
			String time = document
					.select("div.user-info.col-xs-12>div.media>div.media-body.media-middle.media-full.text-muted>"
							+ "small>time")
					.attr("datetime");
			info.setCreateDateTime(DateUtil.parseDateByString(time));

			// 获取新闻标题
			String title1 = document.select("div.content-title.clearfix>h2:eq(0)").text();
			info.setTitle(title1);

			// 获取图片url
			Elements url = document.select("div.featured-image-carousel>div.featured-image-container.js-container>"
					+ "div.slide.js-slide>img:eq(0)");
			if (WebSiteConfig.WEB_SITE == 3) {

				url = document.select("article.card >div.card-block.clearfix> section.blog-main.col-md-8.col-sm-12>"
						+ "img.m-bottom-2.img-responsive");
			}
			if (url.attr("src") != null && !"".equals(url.attr("src"))) {
				info.setImageUrl(url.attr("src"));
			} else {
				info.setImageUrl(url.attr("data-src"));
			}
			info.setImageUrl(ImgUtil.upImg(info.getImageUrl(), info.getNewsUrl(), WebSiteConfig.WEB_MODULE));

			// 获取内容下面的标签
			Elements laElements = document.select("ul.tag-list.list-inline>li.tag");
			StringBuffer sBuffer = new StringBuffer();
			if (laElements != null) {
				for (Element element : laElements) {
					sBuffer.append(element.text() + ",");
				}
				String s1 = sBuffer.toString();
				if (s1.length() > 0) {
					s1 = s1.substring(0, s1.length() - 1);
				}
				info.setTag(s1);
			}

			// 获取新闻内容内容
			Elements contents = document.select("div.card-block.activity-response");
			String content = contents.toString();
			int contentStart = content.indexOf(">");
			int contentindex = content.lastIndexOf("<ul");
			info.setBody(content.substring(contentStart + 1, contentindex > 0 ? contentindex : content.length()));
			info.setBody(ImgUtil.uploadBodyImg(info.getBody(), info.getNewsUrl(), WebSiteConfig.WEB_MODULE));

			// 设置新闻的uuid
			int index = html.indexOf("votingTargetId");
			String com = html.substring(index + 17);
			int end = com.indexOf("\",");

			info.setUUID(com.substring(0, end));

			// 设置用户作者的uuid
			/*
			 * String authorUrl = document .select(
			 * "article.card>div.card-block.clearfix>aside.blog-aside.col-md-4.col-sm-12.m-bottom-2>"
			 * + "article.media>a") .get(0).attr("href");
			 * 
			 * String aString = WebSiteConfig.Web_Url + authorUrl + "/activity";
			 * 
			 * String authorHtml = HtmlUtil.getHtml(aString);
			 * 
			 * Document document2 = Jsoup.parse(authorHtml);
			 * 
			 * String idUrl = document2 .select(
			 * "body#profiles-profile-show-activity>header.profile-header.bg-pfa>div.container>"
			 * +
			 * "div.row>div.col-lg-6.col-md-12.col-sm-12>article.media.header-profile-user-info.m-bottom-2>section.media-body.media-middle.media-full>"
			 * + "h2>a.modal-dialog-link.btn-link.btn-link-primary")
			 * .attr("href");
			 */
			String idUrl = document.select("a.modal-dialog-link.btn-link.btn-link-primary").attr("href");
			String uuid = idUrl.substring(idUrl.lastIndexOf("/") + 1, idUrl.length());

			info.setCreateUserId(uuid);

			// 设置评论的url
			info.setCommonUrl(UrlConfig.getObserverUrl(info.getUUID(), "250"));
		}

	}

	public static List<News_info> getChampionIndex(String html) {
		// TODO Auto-generated method stub

		Document document = null;

		document = Jsoup.parse(html);

		// 过滤节点信息,每条信息分成一个节点
		Element body = document.getElementById("blogs-blog");
		Elements items = body.select("article.container.main-content>ul.list-unstyled>li");

		List<News_info> infos = new ArrayList<>();

		for (Element element : items) {

			// 把参数都转成数据对象
			News_info info = new News_info();

			// 获取图片的地址
			Elements img = element.getElementsByClass("img-responsive m-bottom-2");
			info.setImgUrl(img.get(0).attr("src"));

			// 获取标题
			Elements title = element.getElementsByClass("blog-title hidden-sm-down h2");
			info.setNewsTitle(title.get(0).text());

			// 获取内容
			Elements content = element.select("article.card>div.row>article.col-xs-12>section.card-block.clearfix>"
					+ "section.blog-main.col-md-9.col-sm-12>*:gt(2)");
			info.setContent(StringConfig.getNewsDisc(content.toString()));

			// 获取详情页面的url
			Elements url = element.select("h1");
			String url1 = WebSiteConfig.Web_Url + url.select("a").attr("href");

			info.setUrl(WebSiteConfig.Web_Url + url.select("a").attr("href"));

			// 设置news 的uuid
			info.setUUID(StringConfig.getNewsUUID(url1));

			infos.add(info);

		}

		return infos;
	}

	public static List<News_info> getTraining(String html) {
		// TODO Auto-generated method stub

		Document document = null;

		document = Jsoup.parse(html);

		// 过滤节点信息,每条信息分成一个节点
		Element body = document.getElementById("blogs-blog");
		Elements items = body.select("article.container.main-content>ul.list-unstyled>li");

		List<News_info> infos = new ArrayList<>();

		for (Element element : items) {

			// 把参数都转成数据对象
			News_info info = new News_info();

			// 获取图片的地址
			Elements img = element.getElementsByClass("img-responsive m-bottom-2");
			String string = img.get(0).attr("src");

			// 获取内容
			Elements content = element.select("article.card>div.row>article.col-xs-12>section.card-block.clearfix>"
					+ "section.blog-main.col-md-9.col-sm-12>*:gt(2)");
			info.setContent(StringConfig.getNewsDisc(content.toString()));

			// 获取详情页面的url
			Elements url = element.select("h1");
			String url1 = url.select("a").attr("href");

			info.setUrl(url1);

			// 设置news 的uuid
			info.setUUID(StringConfig.getNewsUUID(url1));

			// 设置图片url
			int start = url1.indexOf("blogs/");
			int end = url1.lastIndexOf("-");
			int start1 = string.lastIndexOf("/");
			info.setImgUrl(WebSiteConfig.COMMON_BODY_URL + url1.substring(start, end) + string.substring(start1));

			infos.add(info);

		}

		return infos;
	}

}
