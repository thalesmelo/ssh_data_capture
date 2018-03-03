package com.dataCapture.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dataCapture.pojo.Detail_info;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月7日
 *
 * @TIME 上午11:10:33
 */
public class Detail_html {

	public static Detail_info getDetail(String html) throws IOException {

		// 把html转换成docment
		Document document = Jsoup.parse(html);

		// 创建详情页面对象
		Detail_info info = new Detail_info();


		// 获取作者uuid
		//info.setCreateUserId(StringConfig.getCreateUserUUID(iconUrl));

		// 获取评论发表时间
		

		// 获取新闻标题
		Elements title = document.select("article .card >div >section>h2");
		info.setTitle(title.get(0).text());

		// 获取图片url
		Elements url = document
				.select("article.card >div.card-block.clearfix> section.blog-main.col-md-8.col-lg-9.col-sm-12>"
						+ "div.featured-container>div.featured-container-image>div[data-view=main]>div>"
						+ "img.img-responsive");
		info.setImageUrl(url.attr("data-src"));

		// 获取内容下面的标签
		//Set<Label> labels = new HashSet<>();
		Elements laElements = document.select("article .card >div > section > section>ul>li");
		StringBuffer sBuffer = new StringBuffer();
		if (laElements != null) {
			for (Element element : laElements) {
				sBuffer.append(element.text() + ",");
			}
			String s1 = sBuffer.toString();
			if (s1.length() > 0) {
				s1 = s1.substring(0, s1.length() - 1);
			}
			info.setLabels(s1);
		}

		// 获取新闻内容内容
		Elements contents = document
				.select("article.card>div.card-block.clearfix>section.blog-main.col-md-8.col-lg-9.col-sm-12>*:gt(3)");

		info.setContent(StringConfig.getNewsBody(contents.toString()));

		// 设置评论的评论总数
		Elements size = document
				.select("article .card>div>section >section.submission-meta.clearfix>h3.underlined-header ");
		String s = size.text();
		String count = s.substring(s.lastIndexOf("(") + 1, s.indexOf(")"));
		if (count.equals("294")) {
			//count="250";
		}
		info.setObserver_size(count);

		// System.err.println(info);

		return info;
	}
	
	public static Detail_info getChampionDetail(String html) throws FailingHttpStatusCodeException, MalformedURLException, IOException, GeneralSecurityException{
		// 把html转换成docment
				Document document = Jsoup.parse(html);

				// 创建详情页面对象
				Detail_info info = new Detail_info();

				// 获取作者名
				Elements name = document.select("article .media > section >h3> a");
				info.setAuthor_name(name.get(0).text());

				// 获取作者标签
				// Set<User_tag> user_tags = new HashSet<>();
				StringBuffer user_tags = new StringBuffer();
				Elements tags = document.select("article .media > section > span");
				if (tags != null) {

					for (int i = 0; i < tags.size() - 1; i++) {

						user_tags.append(tags.get(i).text() + ",");
					}

					String uTag = user_tags.toString();
					if (uTag.length() > 0) {
						uTag = uTag.substring(0, uTag.length() - 1);
					}
					info.setTags(uTag);
				}

				// 设置头像的url
				Elements icon = document
						.select("article.card >div.card-block.clearfix >aside.blog-aside.col-md-4.col-sm-12.m-bottom-2 "
								+ ">article.media>a>img.avatar.avatar-md.hidden-sm-down");
				String iconUrl = icon.attr("src");
				
				info.setAuthor_url(iconUrl);

				// 获取作者uuid
				//info.setCreateUserId(StringConfig.getCreateUserUUID(iconUrl));

				// 获取评论发表时间
				info.setCreate_date(tags.get(tags.size() - 1).text());

				// 获取新闻标题
				Elements title = document.select("article .card >div >section>h2");
				info.setTitle(title.get(0).text());

				// 获取图片url
				Elements url = document
						.select("article.card >div.card-block.clearfix> section.blog-main.col-md-8.col-sm-12>"					
								+ "img.m-bottom-2.img-responsive");
				info.setImageUrl(url.attr("src"));

				// 获取内容下面的标签
				//Set<Label> labels = new HashSet<>();
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
					info.setLabels(s1);
				}

				// 获取新闻内容内容
				Elements contents = document
						.select("article.card>div.card-block.clearfix>section.blog-main.col-md-8.col-sm-12>*:gt(3)");

				info.setContent(StringConfig.getNewsBody(contents.toString()));

				// 设置评论的评论总数
				Elements size = document
						.select("article .card>div>section >section.submission-meta.clearfix>h3.underlined-header ");
				String s = size.text();
				String count = s.substring(s.lastIndexOf("(") + 1, s.indexOf(")"));
				if (count.equals("294")) {
					//count="250";
				}
				info.setObserver_size(count);
				
				//设置新闻的uuid
				int index=html.indexOf("votingTargetId");
			    String com=html.substring(index+17);
			    int end=com.indexOf("\",");
				
				info.setUUID(com.substring(0,end));
				
			
				//设置用户作者的uuid
				String authorUrl=document.select("article.card>div.card-block.clearfix>aside.blog-aside.col-md-4.col-sm-12.m-bottom-2>"
						+ "article.media>a").get(0).attr("href");
				
				String aString="https://www.htcchampions.com/"+authorUrl+"/activity";
				
				String  authorHtml=HtmlUtil.getHtml(aString);
				
				Document document2=Jsoup.parse(authorHtml);
				
				//System.err.println(document2.select("body#profiles-profile-show-activity>header.profile-header.bg-pfa>div.container"));
				String idUrl=document2.select("body#profiles-profile-show-activity>header.profile-header.bg-pfa>div.container>"
						+ "div.row>div.col-lg-6.col-md-12.col-sm-12>article.media.header-profile-user-info.m-bottom-2>section.media-body.media-middle.media-full>"
						+ "h2>a.modal-dialog-link.btn-link.btn-link-primary").attr("href");
				String uuid=idUrl.substring(idUrl.lastIndexOf("/")+1, idUrl.length());
				
                info.setCreateUserId(uuid);
				// System.err.println(info);

				return info;
	}
}
