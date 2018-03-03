package com.dataCapture.util;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月15日
 *
 * @TIME 上午10:09:27
 */
public class UrlConfig {
	

	//评论json网址进行拼接
	public static String getObserverUrl(String keyUrl, String limit) {

		return WebSiteConfig.Common_Url_HEAD + keyUrl + WebSiteConfig.Common_Url_MIDDLE + limit + WebSiteConfig.Common_Url_FOOT;
	}
	//training的评论地址
	public static String getTrainingObserverUrl(String keyUrl, String limit) {

		return WebSiteConfig.Common_Url_HEAD + keyUrl + WebSiteConfig.Common_Url_MIDDLE + limit + "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fblog_post%2Fd97aa382-088e-4e14-9178-dc0eb0411b7e%2Fcomments";
	}
	//获取reply的url
	public static String getReplyUrl(String Parent ,String reply,int replyCount){
		return WebSiteConfig.Reply_Url_Head+Parent+WebSiteConfig.Reply_Url_Middle_1+reply+WebSiteConfig.Reply_Url_Middle_2+replyCount+WebSiteConfig.Reply_Url_Foot;
	}

	//获取地址中的uuid
	public static String getKeyUrl(String url) {

		return url.substring(url.lastIndexOf("post/") + 5);
	}

	//吧评论的json格式转换为正式格式
	public static String getJson(String data) {
	
		return data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
	}

	//拼接人物头像的url
	public static String getIconUrl(String key) {

		return WebSiteConfig.Head_Img_Url + key + ".png";
	}
	
	//转换album相册的url
	public static String getAlbumUrl(String url,String count){
		
		return WebSiteConfig.Web_Url+url+"#search/s:most_recent/n:"+count;
	}
	
	//获取news 的主列表页面
	public static String News_Index_url(int pageIndex){
		switch(WebSiteConfig.WEB_SITE){
		case 1:
			return "https://team.htc.com/blogs/e3e3f816-bd67-43f9-9f5a-3b6ea90c4c06";
		case 2:
			return "https://elevate.htc.com/blogs/2eaa43dc-794e-4c15-bcb2-420b475bb298?blog_posts_page="+pageIndex;
		case 3:
			return "https://www.htcchampions.com/blogs/news?blog_posts_page="+pageIndex;
		}
		System.err.println("网址错误!");
		return null;
	}
	
	
	
}
