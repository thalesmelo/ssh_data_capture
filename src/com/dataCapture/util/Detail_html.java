package com.dataCapture.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.Label;
import com.dataCapture.pojo.Observer_info;
import com.dataCapture.pojo.User_tag;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月7日
 *
 * @TIME 上午11:10:33
 */
public class Detail_html {

	public static Detail_info getDetail(String html) throws IOException {

		// File dFile = new File("res/12.html");
		// 把html转换成docment
		Document document = Jsoup.parse(html);

		// 创建详情页面对象
		Detail_info info = new Detail_info();

		// 获取作者名
		Elements name = document.select("article .media > section >h3> a");
		info.setAuthor_name(name.get(0).text());

		// 获取作者标签
		Set<User_tag> user_tags = new HashSet<>();
		Elements tags = document.select("article .media > section > span");
		for (int i = 0; i < tags.size() - 1; i++) {
			User_tag tag = new User_tag();
			tag.setUserTag(tags.get(i).text());
			user_tags.add(tag);
		}
		info.setTags(user_tags);

		// 设置头像的url
		Elements icon = document
				.select("article.card >div.card-block.clearfix >aside.blog-aside.col-md-4.col-sm-12.m-bottom-2 "
						+ ">article.media>a>img.avatar.avatar-md.hidden-sm-down");
		String iconUrl = icon.attr("src");
		System.err.println(iconUrl);
		info.setAuthor_url(iconUrl);

		// 获取评论发表时间
		info.setCreate_date(tags.get(tags.size() - 1).text());

		// 获取新闻标题
		Elements title = document.select("article .card >div >section>h2");
		info.setTitle(title.get(0).text());

		// 获取图片url
		Elements url = document.select("article .card >div > section >img");
		info.setImageUrl(url.get(0).attr("src"));

		// 获取内容下面的标签
		Set<Label> labels = new HashSet<>();
		Elements laElements = document.select("article .card >div > section > section>ul>li");
		for (Element element : laElements) {
			Label label = new Label();
			label.setLabelName(element.text());
			labels.add(label);
		}
		info.setLabels(labels);

		// 获取新闻内容内容
		Elements contents = document.select("article .card>div>section>p");
		info.setContent(contents.text());

		// 设置评论的评论总数
		Elements size = document
				.select("article .card>div>section >section.submission-meta.clearfix>h3.underlined-header ");
		String s = size.text();
		String count = s.substring(s.lastIndexOf("(") + 1, s.indexOf(")"));
		info.setObserver_size(count);

		// 获取用户评论列表
		/*
		 * List<Observer_info> observer_infos = new ArrayList<>(); Elements
		 * observer = document.select("div .comment-thread>ul>li");
		 * 
		 * for (Element element : observer) { Observer_info observer_info = new
		 * Observer_info(); // S设置用户名 Elements itElements =
		 * element.select("section>div>a");
		 * observer_info.setName(itElements.get(0).text()); // 设置头像url Elements
		 * iconUrl = element.select("section>aside>a>img");
		 * observer_info.setIconUrl(iconUrl.get(0).attr("src")); // 设置评论时间
		 * Elements time = element.select("section>div>p>small");
		 * observer_info.setCommentTime(time.get(0).text()); // 设置评论内容 Elements
		 * content = element.select("section>article>div>div>p");
		 * observer_info.setCommentContent(content.get(1).text());
		 * 
		 * observer_infos.add(observer_info); }
		 * info.setObserver_infos(observer_infos);
		 */

		// System.out.println(info + "\n");
		return info;
	}
}
