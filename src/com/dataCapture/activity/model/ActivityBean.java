package com.dataCapture.activity.model;

import java.util.ArrayList;
import java.util.List;

import com.dataCapture.pojo.Post;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年2月27日
 *
 * @TIME 上午10:25:59
 */
public class ActivityBean {

	public static String jsonString;

	// 返回json数据 参数是activity的index
	public static String getActModel(Post post) {

		switch (WebSiteConfig.WEB_SITE) {
		case 1:

			return teamActModel(post);
		case 2:

			return elevateActModel(post);
		case 3:

			return championActModel(post);

		default:
			return "Error";
		}
	}

	private static String teamActModel(Post post) {
		List<String> param = getParam(post);
		switch (post.getParentId()) {
		case "4147a64f-35e3-4ac4-9c21-1bed795bd3ce":

			return "";
		case "0a6f2b04-c850-4668-9e39-a5ab7633f40e":

			return "";
		case "3":

			return "";
		case "4":

			return "";
		case "5":

			return "";

		default:
			return "";
		}
	}

	private static String elevateActModel(Post post) {
		List<String> param = getParam(post);
		switch (post.getParentId()) {
		case "af048849-2625-4f12-9190-ded94464a956":

			return "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name your list\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":3,\"maxLength\":30,\"responseMessage\":\"Between 3-30 characters, silly.\"},\"HtmlId\":\"11\",\"UUID\":\"a50a043d-e97f-484a-8933-b84dcb0e25c1\",\"nodesText\":\"Name your list\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Tell 'em about yo' five!\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":5,\"maxLength\":500,\"responseMessage\":\"Between 3-500 characters, yo.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"a50a043d-e97f-484a-8933-b84dcb0e25c1\",\"nodesText\":\"\",\"nodesIndex\":2}]";
		case "f3291cb2-5a9d-4945-84e1-843d08febe85":

			return "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\"},\"HtmlId\":\"11\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Name\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Country\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Country\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Phone Model\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Phone Model\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Serial Number\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Serial Number\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"IMEI\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"IMEI\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Contact Number\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Contact Number\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Email\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Email\",\"nodesIndex\":7},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Description of Problem\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"\",\"nodesIndex\":8}]";
		case "565baea6-ea0b-4900-8a40-07d01f79b9df":

			return "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"What's yo' name?\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":2,\"maxLength\":30,\"responseMessage\":\"Between 2 and 30 characters, ya'll.\"},\"HtmlId\":\"11\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"What's yo' name?\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Facebook?\",\"helpText\":\"http://www.facebook.com/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Facebook\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Twitter?\",\"helpText\":\"@YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Twitter?\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Instagram?\",\"helpText\":\"@YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Instagram?\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Pinterest?\",\"helpText\":\"http://www.pinterest.com/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Pinterest?\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Snapchat?\",\"helpText\":\"User name\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Snapchat?\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Tumblr?\",\"helpText\":\"http://YOURNAME.tumblr.com\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Tumblr?\",\"nodesIndex\":7},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Reddit?\",\"helpText\":\"https://www.reddit.com/user/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Reddit?\",\"nodesIndex\":8},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Blog?\",\"helpText\":\"Your URL, silly.\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Blog?\",\"nodesIndex\":9},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Other social?\",\"helpText\":\"Enter complete URL and/or username\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"Other social?\",\"nodesIndex\":10},{\"Title\":\"Yes / No\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"You agree that HTC Elevate can share the above URLs and/or usernames from HTC Elevate social media. Your information will only be shared from HTC Elevate social media accounts.\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"13\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\"yes\",\"nodesIndex\":11}]";
		case "20f01de8-d8a0-47fc-a83a-cafff50ae6ce":

			return "[{\"Title\":\"Featured Image\",\"Type\":\"3\",\"Template\":\"/Module/PageInput\",\"NodesContent\":{\"qes\":\"Share your photo here\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"4\",\"UUID\":\"1a138372-26ae-4a2f-9403-26fc582a731e\",\"nodesText\":\"\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Tell us about your photo\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"1a138372-26ae-4a2f-9403-26fc582a731e\",\"nodesText\":\"\",\"nodesIndex\":2}]		";
		case "fc80c09d-1719-4dcd-8611-d0b8c29126a8":

			return "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\"},\"HtmlId\":\"11\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Name\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Country\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Country\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Phone Model\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Phone Model\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Serial Number\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Serial Number\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"IMEI\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"IMEI\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Contact Number\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Contact Number\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Email\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"Email\",\"nodesIndex\":7},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Description of Problem\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"\",\"nodesIndex\":8}]}";

		default:
			return "";
		}
	}

	private static String championActModel(Post post) {
		List<String> param = getParam(post);
		switch (post.getParentId()) {
		case "c8138e7b-3143-462d-9a2e-c48d091339b4":

			return "";
		case "44e1d8d1-acfe-47dc-893a-1f3be2aa5541":

			return "";
		case "3":

			return "";
		case "4":

			return "";
		case "5":

			return "";

		default:
			return "";
		}
	}

	private static List<String> getParam(Post post) {
		List<String> param = new ArrayList<>();

		String html = post.getBody();
		String[] item = html.split("<h4 class=\"h4 \">");
		for (int i = 1; i < item.length; i++) {
			String val = item[i].substring(item[i].indexOf("</h4>") + 5, item[i].length());
			if (i == item.length - 1) {
				val = val.replace("</body>", "").replace("</html>", "");
			}
		}

		return param;

	}
}
