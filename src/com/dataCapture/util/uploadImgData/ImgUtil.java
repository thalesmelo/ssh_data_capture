package com.dataCapture.util.uploadImgData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月25日
 *
 * @TIME 上午10:58:05
 */
public class ImgUtil {

	// 下载包含在标签中的img
	public static String uploadBodyImg(String html, String referer, WebModule module) {
		if (!WebSiteConfig.isUploadImg) {
			return html;
		}

		Document document = Jsoup.parse(html);

		// 获取所有图片的标签
		Elements img = document.getElementsByTag("img");

		for (Element element : img) {
			// 循环获取src
			String url = element.attr("src");
			if (url == null || "".equals(url)) {
				url = element.attr("data-src");
			}
			// 下载图片到本地 .并把新地址赋给img
			String imgUrl = null;
			imgUrl = HtmlUtil.openStreamByUrl(url, referer, module ,null);
			if (imgUrl != null && !"".equals(imgUrl)) {
				element.attr("src", imgUrl);
			}
		}

		return document.toString();
	}

	// 直接根据url下载图片
	public static String upImg(String url, String referer, WebModule module) {
		if (!WebSiteConfig.isUploadImg||url==null) {
			return url;
		}

		// 当有多张图片的状况
		if (url.indexOf(",") > 0) {
			String[] urlList = url.split(",");
			StringBuffer sbBuffer = new StringBuffer();
			for (String URL : urlList) {
				sbBuffer.append(HtmlUtil.openStreamByUrl(URL, referer, module,null) + ",");
			}
			String sbURL = sbBuffer.toString();
			if (sbURL.length() > 0) {
				sbURL = sbURL.substring(0, sbURL.length() - 1);
				return sbURL;
			}
		} else {

			// 单一图片
			String imgUrl = null;
			imgUrl = HtmlUtil.openStreamByUrl(url, referer, module,null);

			if (imgUrl != null && !"".equals(imgUrl)) {
				return imgUrl;
			}
			return url;
		}
		return url;

	}
	//下载封面图片 附带 path参数
	public static String upImg(String url, String referer,WebModule module,String path){
		if (!WebSiteConfig.isUploadImg||url==null) {
			return url;
		}

		// 当有多张图片的状况
		if (url.indexOf(",") > 0) {
			String[] urlList = url.split(",");
			StringBuffer sbBuffer = new StringBuffer();
			for (String URL : urlList) {
				sbBuffer.append(HtmlUtil.openStreamByUrl(URL, referer, module,path) + ",");
			}
			String sbURL = sbBuffer.toString();
			if (sbURL.length() > 0) {
				sbURL = sbURL.substring(0, sbURL.length() - 1);
				return sbURL;
			}
		} else {

			// 单一图片
			String imgUrl = null;
			imgUrl = HtmlUtil.openStreamByUrl(url, referer, module,path);

			if (imgUrl != null && !"".equals(imgUrl)) {
				return imgUrl;
			}
			return url;
		}
		return url;
	}
}
