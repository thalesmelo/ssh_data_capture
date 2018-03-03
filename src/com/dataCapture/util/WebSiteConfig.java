package com.dataCapture.util;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.Enum.WebSite;

import antlr.collections.List;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月9日
 *
 * @TIME 下午2:06:30
 */
public class WebSiteConfig {

	// 网站标记
	public static int WEB_SITE;

	// 拼接评论json网址的常量
	public static String Common_Url_HEAD;
	public static String Common_Url_MIDDLE;
	public static String Common_Url_FOOT;

	// 评论回复的评论url
	public static String Reply_Url_Head;
	public static String Reply_Url_Middle_1;
	public static String Reply_Url_Middle_2;
	public static String Reply_Url_Foot;

	// 拼接人物头像的
	public static String Head_Img_Url;

	// 拼接评论body里面的图片url
	public static String COMMON_BODY_URL;

	// 网址主页面地址
	public static String Web_Url;

	// album相册的url头部
	// public static String Album_Head_Url;

	// 登录的url
	public static String Login_Url;

	// 登录账户和密码
	public static String ACCOUNT = "Yitong_Lin@htc.com";
	public static String Password = "carbondioxide$579";

	// 抓取的模块
	public static WebModule WEB_MODULE;

	// activity的UUID
	public static String Activity_UUID;

	// file的name
	public static String FILE_NAME;

	// 存放photohtml的folder
	public static String PHOTO_FOLDER;
	
	//网络图片服务器的地址
	public static String IMG_Server_Url;
	
	//用户列表的referer
	public static String User_Referer;
	
	//是否下载图片
	public static boolean isUploadImg=false;
	
	//单个抓取的数据条数
	public static Integer Total_index=0;
	
	//training 的url
	public static String Traning_Img_Url="https://chaordix-htc-champions-prod.s3.amazonaws.com/community/blogs/2/";
	
	
	
	
	// 数据初始化
	public static void init(WebSite website) {
		IMG_Server_Url="https://htcresources.blob.core.windows.net/resource/";
		Progress.resetProgress();
		Progress.error=false;
		switch (website) {
		case TEAM:
			Common_Url_HEAD = "https://team.htc.com/comments/blog_post/";
			Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
			Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fblog_post%2F28b12835-ae46-49e3-80f6-b3958ceea96e%2Fcomments";
			Head_Img_Url = "https://chaordix-htc-team-prod.s3.amazonaws.com/community/stream_thumbnails/user/";
			COMMON_BODY_URL = "https://chaordix-htc-team-prod.s3.amazonaws.com/community/";
			Web_Url = "https://team.htc.com";
			WEB_SITE = 1;
			Login_Url = "https://team.htc.com/authentication/password/login";
			Reply_Url_Head = "https://team.htc.com/comments/blog_post/";
			Reply_Url_Middle_1 = "/comments/";
			Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
			Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fblog_post%2F46c21119-5351-472a-b150-9a2ab69cb6d6%2Fcomments";
			User_Referer="https://team.htc.com/community";
			break;

		case ELEVATE:
			Common_Url_HEAD = "https://elevate.htc.com/comments/blog_post/";
			Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
			Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fblog_post%2F62680bea-0b45-4502-9088-d20a9d314b2b%2Fcomments";
			Head_Img_Url = "https://chaordix-htc-elevate4-prod.s3.amazonaws.com/community/stream_thumbnails/user/";
			COMMON_BODY_URL = "https://chaordix-htc-elevate4-prod.s3.amazonaws.com/community/";
			Web_Url = "https://elevate.htc.com";
			WEB_SITE = 2;
			Login_Url = "https://elevate.htc.com/authentication/password/login";
			Reply_Url_Head = "https://elevate.htc.com/comments/blog_post/";
			Reply_Url_Middle_1 = "/comments/";
			Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
			Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fblog_post%2F62680bea-0b45-4502-9088-d20a9d314b2b%2Fcomments";
			PHOTO_FOLDER = "photos/elevate";
			User_Referer="https://elevate.htc.com/community";
			break;

		case CHAMPIONS:
			Common_Url_HEAD = "https://www.htcchampions.com/comments/blog_post/";
			Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
			Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fblog_post%2F4083f6a6-7960-48ac-a85f-6ec484a8ceb6%2Fcomments";
			Head_Img_Url = "https://chaordix-htc-champions-prod.s3.amazonaws.com/community/avatars/";
			COMMON_BODY_URL = "https://chaordix-htc-champions-prod.s3.amazonaws.com/community/";
			Web_Url = "https://www.htcchampions.com";
			WEB_SITE = 3;
			Login_Url = "https://www.htcchampions.com/authentication/login";
			Reply_Url_Head = "https://www.htcchampions.com/comments/blog_post/";
			Reply_Url_Middle_1 = "/comments/";
			Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
			Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fblog_post%2Fed675bee-608e-400e-8c65-6610182f1d75%2Fcomments";
			PHOTO_FOLDER = "photos/champions";
			User_Referer="https://www.htcchampions.com/community";
			break;

		default:
			break;
		}
	}

	// 初始化的重载
	public static void init(WebSite webSite, WebModule webModule) {
		init(webSite);
		WEB_MODULE = webModule;
		if (webModule == WebModule.FORUM || webModule == WebModule.DISSCUSSION) {
			switch (webSite) {
			case CHAMPIONS:
				Common_Url_HEAD = "https://www.htcchampions.com/comments/submission/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fsubmission%2F1c7f4273-70b1-4016-a87b-7745d445656c%2Fcomments";
				Reply_Url_Head = "https://www.htcchampions.com/comments/submission/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fsubmission%2F1c7f4273-70b1-4016-a87b-7745d445656c%2Fcomments";
				break;

			case ELEVATE:
				Common_Url_HEAD = "https://elevate.htc.com/comments/submission/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fsubmission%2F025d4e37-5161-4280-b907-58ac2b40b018%2Fcomments";
				Reply_Url_Head = "https://elevate.htc.com/comments/submission/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fsubmission%2F025d4e37-5161-4280-b907-58ac2b40b018%2Fcomments";
				break;
				
			case TEAM:
				Common_Url_HEAD = "https://team.htc.com/comments/submission/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fsubmission%2Fc27bbd1a-eff9-44c1-b2e3-6d63ed7e5265%2Fcomments";
				Reply_Url_Head = "https://team.htc.com/comments/submission/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fsubmission%2Fc27bbd1a-eff9-44c1-b2e3-6d63ed7e5265%2Fcomments";
				break;
				
			default:
				break;
			}

		}

		if (webModule == WebModule.ACTIVITY) {
			switch (webSite) {
			case CHAMPIONS:
				Common_Url_HEAD = "https://www.htcchampions.com/comments/study_response/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fstudy_response%2F6b03dc93-5a94-4cd7-94e3-699325e63bb0%2Fcomments";
				Reply_Url_Head = "https://www.htcchampions.com/comments/study_response/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Fstudy_response%2Fa04f3b99-b8e2-4836-904b-1a2fbf7d8cfd%2Fcomments";
				break;
			case ELEVATE:
				Common_Url_HEAD = "https://elevate.htc.com/comments/study_response/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fstudy_response%2Fd3f91118-1ba0-43bc-8f45-7dfbb1a07d96%2Fcomments";
				Reply_Url_Head = "https://elevate.htc.com/comments/study_response/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Fstudy_response%2Fd3f91118-1ba0-43bc-8f45-7dfbb1a07d96%2Fcomments";
				break;
				
			case TEAM:
				Common_Url_HEAD = "https://team.htc.com/comments/study_response/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fstudy_response%2Ff8fb6451-3322-48f2-83cf-1ccd2a20f431%2Fcomments";
				Reply_Url_Head = "https://team.htc.com/comments/study_response/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fstudy_response%2Ff8fb6451-3322-48f2-83cf-1ccd2a20f431%2Fcomments";
				break;
				
			default:
				break;

			}
		}
		
		if (webModule==WebModule.PHOTO) {
			switch (webSite) {
			case CHAMPIONS:
				Common_Url_HEAD = "https://www.htcchampions.com/comments/album_image/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Falbum_image%2Fd1fa59ee-5850-49ba-ac87-075e706b8371%2Fcomments";
				Reply_Url_Head = "https://www.htcchampions.com/comments/album_image/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Fwww.htcchampions.com%2Fcomments%2Falbum_image%2Fd1fa59ee-5850-49ba-ac87-075e706b8371%2Fcomments";
				break;

			case ELEVATE:
				Common_Url_HEAD = "https://elevate.htc.com/comments/album_image/";
				Common_Url_MIDDLE = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";
				Common_Url_FOOT = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Falbum_image%2Fa56646ea-2c1e-44f8-ad17-3dfa22e402c1%2Fcomments";
				Reply_Url_Head = "https://elevate.htc.com/comments/album_image/";
				Reply_Url_Middle_1 = "/comments/";
				Reply_Url_Middle_2 = "/replies?order=newest&from=max&style=flat&max_id=&min_id=&limit=";
				Reply_Url_Foot = "&id=comments-query-https%3A%2F%2Felevate.htc.com%2Fcomments%2Falbum_image%2Fa56646ea-2c1e-44f8-ad17-3dfa22e402c1%2Fcomments";
				break;
				
			default:
				break;
			}
		}
	}

	// 初始化重载
	public static void init(WebSite webSite, WebModule webModule, String title) {
		init(webSite, webModule);
		Activity_UUID = UUIDConfig.getActivityUUID(title);
		FILE_NAME = UUIDConfig.getFileName(title);
	}
	
	//开启下载图片	
	public static void isUploadIMG(boolean b){
		isUploadImg=b;
	}
	
	public static void setTotalSize(Integer size){
		Total_index=size;
	}
}
