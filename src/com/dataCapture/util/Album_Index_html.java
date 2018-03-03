package com.dataCapture.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CosNaming.NamingContextExtPackage.URLStringHelper;

import com.dataCapture.model.AlbumModel;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月10日
 *
 * @TIME  上午10:46:25
 */
public class Album_Index_html {

	public static List<AlbumModel> getAlbum(String html){
		
		//把htmlString转成document
		Document document=Jsoup.parse(html);
		
		//获取每个相册的li节点
		Elements ul=document.select("body.galleries-show_by_alias>article.container.main-content>"
				+ "article#search-app>div.row>section.tile-main.search-main.col-lg-9.col-md-12>"
				+ "div#search-results>ul.list-unstyled.search-result-view.clearfix.m-bottom-1>li.panel-tile");
		
		List<AlbumModel> models=new ArrayList<>();
		
		//循环遍历
		for (Element li : ul) {
			AlbumModel model=new AlbumModel();
			
			//获取主图的url
			Elements img=li.select("section.card.gallery-tile>header.card-img-top>img");
			model.setImgUrl(img.get(0).attr("src"));
			
			//获取图片数量
			Elements count=li.select("section.card.gallery-tile>footer.card-footer>div.media-right.media-middle>"
					+ "ul.list-inline>li.text-center>span.small");
			model.setImgCount(count.get(0).text());
			
			//获取album的url
			Elements url=li.select("section.card.gallery-tile>header.card-img-top>a");
			String urlString=url.get(0).attr("href");
			model.setItemUrl(UrlConfig.getAlbumUrl(urlString, model.getImgCount()));
			
			models.add(model);
			System.err.println(model);
		}
		return models;
	}
}
