package com.dataCapture.util;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月15日
 *
 * @TIME 上午10:09:27
 */
public class UrlConfig {

	private final static String HEAD_URL = "https://team.htc.com/comments/blog_post/";

	private final static String MIDDLE_URL = "/comments?order=newest&from=max&style=children&max_id=&min_id=&limit=";

	private final static String END_URL = "&id=comments-query-https%3A%2F%2Fteam.htc.com%2Fcomments%2Fblog_post%2F28b12835-ae46-49e3-80f6-b3958ceea96e%2Fcomments";

	public static String getObserverUrl(String keyUrl, String limit) {

		return HEAD_URL + keyUrl + MIDDLE_URL + limit + END_URL;
	}

	public static String getKeyUrl(String url) {

		return url.substring(url.lastIndexOf("post/") + 5);
	}

	public static String getJson(String data) {
		System.err.println(data.substring(data.indexOf("[") + 1, data.lastIndexOf("]")));
		return data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
	}

	public static String getIconUrl(String key) {

		return "https://chaordix-htc-team-prod.s3.amazonaws.com/community/stream_thumbnails/user/" + key + ".png";
	}
}
