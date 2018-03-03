package com.dataCapture.util;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月8日
 *
 * @TIME  下午2:51:41
 */
public class StringConfig {
	
	//获取作者的uuid
	public static String getCreateUserUUID(String s){
		int start=s.lastIndexOf("user/");
		String uuid=s.substring(start+5,s.length()-4);
	return uuid;
	}
	
	//获取news的uuid
	public static String getNewsUUID(String s){
		int start=s.lastIndexOf("post/");
		return s.substring(start+5);
	}
	
	//从json中获取评论正文的图片地址
	public static String getCommomImage(String s){
		int start=s.indexOf("{\"height\":100,\"width\":100},\"path\":\"comments/");
		int end=s.indexOf("square-100.");
		return WebSiteConfig.COMMON_BODY_URL+s.substring(start+35,end+14);
	}
	
	//champions评论图片
	public static String getCommonImgCham(String s){
		int index=s.indexOf("\"width\": [100], \"height\": [100]");
		int index1=s.indexOf("\"height\":[100],\"width\":[100]");
		int index2=s.indexOf("\"height\":100,\"width\":100");
		if (index<0) {
			index=index1<0?index2:index1;
		}
		String sub=s.substring(index);
		int start=sub.indexOf("path");
		int end=sub.indexOf("subtype");
		
		
		return WebSiteConfig.COMMON_BODY_URL+sub.substring(start+7, end-3);
	}
	
	//从html中获取新闻body
	public static String getNewsBody(String s){
		int end=s.indexOf("<hr>");
		return s.substring(0,end);
	}
	
	//获取news的description
	public static String getNewsDisc( String s){
	    int end=s.indexOf("<a");
	    return s.substring(0,end);
	}
	
	
	

}
