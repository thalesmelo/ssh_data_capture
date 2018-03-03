package com.dataCapture.resolver;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.bean.UserBean;
import com.dataCapture.util.DateUtil;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月19日
 *
 * @TIME 下午5:59:20
 */
public class User_index {

	public static List<UserBean> getUsers(String html) {
		Document document = Jsoup.parse(html);
		List<UserBean> beans = new ArrayList<>();

		if (WebSiteConfig.WEB_SITE == 3) {

			Elements liElements = document.select("body#users-community>article.container.main-content>"
					+ "article#search-app>div.row>section.tile-main.search-main.col-lg-9.col-md-12>"
					+ "div#search-results>ul.list-unstyled.search-result-view.clearfix>li.panel-tile");

			for (Element element : liElements) {
				UserBean bean = new UserBean();

				// 头像地址
				String iconUrl = element
						.select("article.col-xs-12.col-sm-6.col-md-6.col-lg-4>section.card.people-tile.community"
								+ ">section.card-block>header.m-bottom-1.clearfix>div.pull-left>a>img")
						.get(0).attr("src");
				int start = iconUrl.indexOf("(");
				int end = iconUrl.indexOf(")");
				if (start > 0 && end > 0) {
					iconUrl = iconUrl.substring(0, start) + iconUrl.substring(end + 1);
				}

				bean.setHeaderImgUrl(WebSiteConfig.Head_Img_Url + iconUrl.substring(iconUrl.lastIndexOf("/") + 1));

				// uuid
				Elements uuid = element
						.select("article.col-xs-12.col-sm-6.col-md-6.col-lg-4>section.card.people-tile.community"
								+ ">section.card-block.card-bottom>a.btn.btn-primary.btn-block.js-follow-btn");

				if (uuid != null && !"".equals(uuid) && !uuid.isEmpty()) {
					bean.setUUID(uuid.get(0).attr("data-uuid"));
				}

				// 创建时间
				String date = element
						.select("article.col-xs-12.col-sm-6.col-md-6.col-lg-4>section.card.people-tile.community"
								+ ">section.card-block>p.text-uppercase>small>em>time")
						.get(0).attr("datetime");
				bean.setCreateDateTime(DateUtil.parseDateByString(date));

				beans.add(bean);

				// Progress.Progressing();
				// System.out.println(bean);
			}
		}

		else {
			// team 和elevate
			Elements liElements = document.select("ul.list-unstyled.search-result-view.clearfix.m-bottom-1>li");

			for (Element element : liElements) {
				UserBean bean = new UserBean();

				// 头像地址
				String iconUrl = element
						.select("img.avatar.avatar-md")
						.get(0).attr("src");
				int start = iconUrl.indexOf("(");
				int end = iconUrl.indexOf(")");
				if (start > 0 && end > 0) {
					iconUrl = iconUrl.substring(0, start) + iconUrl.substring(end + 1);
				}

				bean.setHeaderImgUrl(WebSiteConfig.Head_Img_Url + iconUrl.substring(iconUrl.lastIndexOf("/") + 1));

				// uuid
				Elements uuid = element
						.select("a.btn.follow-button.btn-flat.btn-block ");

				if (uuid != null && !"".equals(uuid) && !uuid.isEmpty()) {
					bean.setUUID(uuid.get(0).attr("data-uuid"));
				}

				// 创建时间
				String date = element
						.select("p.text-uppercase>small>em>time")
						.get(0).attr("datetime");
				bean.setCreateDateTime(DateUtil.parseDateByString(date));

				beans.add(bean);
			}

			
		}
		return beans;
	}
}
