package com.dataCapture.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.AlbumBean;
import com.dataCapture.bean.PhotoBean;
import com.dataCapture.util.DateUtil;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.uploadImgData.ImgUtil;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月19日
 *
 * @TIME 下午5:00:40
 */
public class Album_index {

	public static AlbumBean getAlbum(String html) {
		AlbumBean album = new AlbumBean();
		Document document = Jsoup.parse(html);

		if (WebSiteConfig.WEB_SITE == 3) {

			// 设置标题
			String title = document.select("article.container.main-content>" + "div.row>section:eq(0)>h2:eq(0)").text();
			album.setTitle(title);

			// 设置描述
			String des = document
					.select("article.container.main-content>" + "div.row>section:eq(0)>section.cms.m-bottom-2").text();
			album.setDescription(des);

			// 设置tag
			Elements tagLi = document.select(
					"article.container.main-content>" + "div.row>section:eq(0)>ul.tag-list.list-unstyled>li.tag");
			StringBuffer sbBuffer = new StringBuffer();
			for (Element element : tagLi) {
				if (element != null) {
					sbBuffer.append(element.select("a").text() + ",");
				}
			}
			String tags = sbBuffer.toString();
			if (tags != null && !"".equals(tags)) {
				tags = tags.substring(0, tags.length() - 1);
			}
			album.setTag(tags);

			// 获取作者的uuid
			String uuid = document.select("article.container.main-content>"
					+ "div.row>section:eq(0)>div.media.m-bottom-2>section.media-body.media-full" + ">strong>a:eq(0)")
					.attr("href");
			album.setUserid(uuid.substring(uuid.lastIndexOf("/") + 1));

			// 创建时间
			String date = document.select("article.container.main-content>"
					+ "div.row>section:eq(0)>div.media.m-bottom-2>section.media-body.media-full"
					+ ">p.text-muted>time:eq(0)").attr("datetime");
			if (date != null && !"".equals(date)) {

				album.setCreateDateTime(DateUtil.parseDateByString(date));
			}

			// 设置uuid
			album.setUUID(UUID.randomUUID().toString());
			System.out.println(album);
		} else {
			// 设置标题
			String title = document
					.select("section.col-xs-12.col-sm-12.col-md-10.col-md-offset-1.col-lg-8.col-lg-offset-2>h2:eq(0)")
					.text();
			album.setTitle(title);

			// 设置描述
			String des = document.select("section.cms.m-bottom-2").text();
			album.setDescription(des);

			// 设置tag
			Elements tagLi = document.select("ul.tag-list.list-unstyled>li.tag");
			StringBuffer sbBuffer = new StringBuffer();
			for (Element element : tagLi) {
				if (element != null) {
					sbBuffer.append(element.select("a").text() + ",");
				}
			}
			String tags = sbBuffer.toString();
			if (tags != null && !"".equals(tags)) {
				tags = tags.substring(0, tags.length() - 1);
			}
			album.setTag(tags);

			// 获取作者的uuid
			String uuid = document.select("a.modal-dialog-link.btn-link.btn-link-primary").attr("href");

			album.setUserid(uuid.substring(uuid.lastIndexOf("/") + 1));

			// 创建时间
			String date = document.select("time.timeago").attr("datetime");
			if (date != null && !"".equals(date)) {

				album.setCreateDateTime(DateUtil.parseDateByString(date));
			}

			// 设置uuid
			album.setUUID(UUID.randomUUID().toString());
			System.out.println(album);
		}
		return album;
	}

	public static List<PhotoBean> photo_index(String html, AlbumBean albumBean) {
		Document document = Jsoup.parse(html);
		
		
		
		if (WebSiteConfig.WEB_SITE == 3) {

			Elements li = document.select("div#search-results>ul.list-unstyled.search-result-view.clearfix>li");

			List<PhotoBean> beans = new ArrayList<>();
			for (Element element : li) {
				PhotoBean bean = new PhotoBean();

				// 获取每张图片的url
				String photoUrl = element.select("article.col-xs-12.col-sm-6.col-md-4.col-lg-4>"
						+ "section.card.gallery-tile>header.card-img-top>a:eq(0)").attr("href");
				bean.setPhotoUrl(photoUrl);

				// 设置关联相册的uuid
				bean.setIds(albumBean.getUUID());
				
				// 查看次数
			
				String likeNum = null;
				String commonNum = null;
				
			
					// like数量
					likeNum = element.select("i.ss-icon.ss-gizmo.ss-heart").next("span").text();
					// 评论
					commonNum = element.select("i.ss-icon.ss-gizmo.ss-chat").next("span").text();

				
				
				if (likeNum != null && !"".equals(likeNum)) {
					bean.setLoveNum(Integer.parseInt(likeNum));
				}
				if (commonNum != null && !"".equals(commonNum)) {
					bean.setCommonNum(Integer.parseInt(commonNum));
				}

				// System.out.println(bean);
				beans.add(bean);
			}

			return beans;
		} else {
			Elements li = document
					.select("div#search-results>ul.list-unstyled.search-result-view.clearfix.m-bottom-1>li");

			List<PhotoBean> beans = new ArrayList<>();
			for (Element element : li) {
				PhotoBean bean = new PhotoBean();

				// 获取每张图片的url
				String photoUrl = element.select("header.card-img-top.text-center>a:eq(0)").attr("href");
				bean.setPhotoUrl(photoUrl);

				// 设置关联相册的uuid
				bean.setIds(albumBean.getUUID());
				// System.out.println(bean);
				
				
				// 查看次数
			
				String likeNum = null;
				String commonNum = null;
				
			
					// like数量
					likeNum = element.select("i.ss-pika.ss-heart").next("span").text();
					// 评论
					commonNum = element.select("i.ss-pika.ss-chat").next("span").text();

				
				
				if (likeNum != null && !"".equals(likeNum)) {
					bean.setLoveNum(Integer.parseInt(likeNum));
				}
				if (commonNum != null && !"".equals(commonNum)) {
					bean.setCommonNum(Integer.parseInt(commonNum));
				}
				beans.add(bean);
			}

			return beans;
		}
	}

	public static void photoInfo(PhotoBean bean) {
		String html = null;
		try {
			html = HtmlUtil.getHtml(bean.getPhotoUrl());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = Jsoup.parse(html);

		if (WebSiteConfig.WEB_SITE == 3) {

			// 设置作者uuid
			String uuid = document.select("body#galleries-album-image>article.container.main-content>div.row>"
					+ "section.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
					+ "div.media.m-bottom-2>section.media-body.media-full>strong>a:eq(0)").attr("href");
			bean.setUserid(uuid.substring(uuid.lastIndexOf("/") + 1));

			// 标题
			Elements title = document.select("body#galleries-album-image>article.container.main-content>div.row>"
					+ "section.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>" + "h2:eq(0)");
			if (title != null) {
				bean.setTitle(title.text());
			}

			// 描述
			String deString = document.select("body#galleries-album-image>article.container.main-content>div.row>"
					+ "section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
					+ "section:eq(0)").text();
			if (deString != null && !"".equals(deString)) {
				bean.setDescription(deString);
			}

			// 创建时间
			String date = document
					.select("body#galleries-album-image>article.container.main-content>div.row>"
							+ "section.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
							+ "div.media.m-bottom-2>section.media-body.media-full>p.text-muted>time:eq(0)")
					.attr("datetime");
			if (date != null && !"".equals(date)) {

				bean.setCreateDateTime(DateUtil.parseDateByString(date));
			}

			// 图片地址
			switch (WebSiteConfig.WEB_SITE) {
			case 3:
				String url = document.select("body#galleries-album-image>article.container.main-content>div.row>"
						+ "section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
						+ "section.submission-content.m-bottom-2.carousel-inner>" + "a.attachment-image>img:eq(0)")
						.attr("src");
				bean.setImg(url);
				break;
			case 2:
				String url1 = document.select("body#galleries-album-image>article.container.main-content>div.row>"
						+ "section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
						+ "div.featured-container>section.submission-content.m-bottom-2.carousel-inner>"
						+ "a.attachment-image>div.p-y-1.p-x-3>img:eq(0)").attr("src");
				bean.setImg(url1);
				break;
			default:
				break;
			}
			bean.setImg(ImgUtil.upImg(bean.getImg(), bean.getPhotoUrl(), WebModule.PHOTO));

			// uuid
			int start = html.indexOf("votingTargetId");
			String teString = html.substring(start);
			String UUID = teString.substring(teString.indexOf("\"") + 1, teString.indexOf("\","));
			bean.setUUID(UUID);

			// tag
			Elements tagli = document.select("body#galleries-album-image>article.container.main-content>div.row>"
					+ "section.submission-container.col-xs-12.col-sm-12.col-md-8.col-md-offset-2.col-lg-8.col-lg-offset-2>"
					+ "ul.tag-list.list-unstyled>li.tag");
			StringBuffer tags = new StringBuffer();
			if (tagli != null) {
				for (Element li : tagli) {
					tags.append(li.select("a").text() + ",");
				}
				String tagString = tags.toString();
				if (tagString != null && !"".equals(tagString)) {
					tagString = tagString.substring(0, tagString.length() - 1);
					bean.setTags(tagString);
				}
			}

			// 设置评论url
			bean.setCommonUrl(UrlConfig.getObserverUrl(bean.getUUID(), "250"));

		} else {

			// 设置作者uuid
			String uuid = document.select("a.modal-dialog-link.btn-link.btn-link-primary").attr("href");
			bean.setUserid(uuid.substring(uuid.lastIndexOf("/") + 1));

			// 标题
			Elements title = document
					.select("section.col-xs-12.col-sm-12.col-md-10.col-md-offset-1.col-lg-8.col-lg-offset-2:eq(0)>"
							+ "h2:eq(0)");
			if (title != null) {
				bean.setTitle(title.text());
			}

			// 描述
			String deString = document.select("section.cms").text();
			if (deString != null && !"".equals(deString)) {
				bean.setDescription(deString);
			}

			// 创建时间
			String date = document.select("time.timeago").attr("datetime");
			if (date != null && !"".equals(date)) {

				bean.setCreateDateTime(DateUtil.parseDateByString(date));
			}

			// 图片地址

			String url = document.select("img.img-responsive.center-block").attr("src");
			bean.setImg(url);

			bean.setImg(ImgUtil.upImg(bean.getImg(), bean.getPhotoUrl(), WebModule.PHOTO));

			// uuid
			int start = html.indexOf("votingTargetId");
			String teString = html.substring(start);
			String UUID = teString.substring(teString.indexOf("\"") + 1, teString.indexOf("\","));
			bean.setUUID(UUID);

			// tag
			Elements tagli = document.select("ul.tag-list.list-unstyled>li.tag");
			StringBuffer tags = new StringBuffer();
			if (tagli != null) {
				for (Element li : tagli) {
					tags.append(li.select("a").text() + ",");
				}
				String tagString = tags.toString();
				if (tagString != null && !"".equals(tagString)) {
					tagString = tagString.substring(0, tagString.length() - 1);
					bean.setTags(tagString);
				}
			}

			// 设置评论url
			bean.setCommonUrl(UrlConfig.getObserverUrl(bean.getUUID(), "250"));
		}
	}
}
