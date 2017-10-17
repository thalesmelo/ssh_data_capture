package com.dataCapture.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.pojo.Label;
import com.dataCapture.pojo.News_info;
import com.dataCapture.pojo.User_tag;

/**
 * @author zhuCan
 *
 * @DATE 2017年9月30日
 *
 * @TIME 上午9:10:01
 */
public class Index_html {

	/**
	 * @param args
	 */
	public static List<News_info> getIndex(String html) {
		// TODO Auto-generated method stub

		// 获取html的节点
		//File file = new File("src/res/123.html");
		Document document = null;
		// document = Jsoup.parse(file, "utf-8");
		document = Jsoup.parse(html);

		// 过滤节点信息,每条信息分成一个节点
		Element body = document.getElementById("blogs-blog");
		Elements ulElements = body.getElementsByClass("list-unstyled");
		Elements items = ulElements.get(0).children();
		List<News_info> infos = new ArrayList<>();

		for (Element element : items) {

			// 把参数都转成数据对象
			News_info info = new News_info();

			// 创建标签对象
			List<Label> labels = new ArrayList<>();
			// 获取标签
			Elements lab = element.getElementsByClass("tag");
			for (Element element2 : lab) {
				Label label = new Label();
				label.setLabelName(element2.text());
				labels.add(label);
			}
			info.setLabel(labels);

			// 获取作者名
			Elements name = element.getElementsByTag("h3");
			info.setAuthorName(name.get(0).text());

			// 获取日期
			Elements date = element.getElementsByClass("tile-date text-muted");
			info.setDate(date.text());

			// 获取作者标签
			Elements tag = element.getElementsByClass("label label-default");
			List<User_tag> tags = new ArrayList<>();
			for (Element element2 : tag) {
				User_tag tag2 = new User_tag();
				tag2.setUserTag(element2.text());
				tags.add(tag2);
			}
			info.setTag(tags);

			// 获取图片的地址
			Elements img = element.getElementsByClass("img-responsive m-bottom-2");
			info.setImgUrl(img.get(0).attr("src"));

			// 获取标题
			Elements title = element.getElementsByClass("blog-title hidden-sm-down h2");
			info.setNewsTitle(title.get(0).text());

			// 获取内容
			Elements content = element.getElementsByTag("p");
			info.setContent(content.get(1).text());
			
			//获取详情页面的url
			Elements url=element.select("h1");
			info.setUrl("https://team.htc.com"+url.select("a").attr("href"));

			infos.add(info);

		}

		/*for (News_info news_info : infos) {
			System.out.println(news_info + "\n");
		}*/

		return infos;
	}

}
