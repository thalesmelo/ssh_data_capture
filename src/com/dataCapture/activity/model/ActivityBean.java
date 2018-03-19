package com.dataCapture.activity.model;

import java.util.ArrayList;
import java.util.List;

import com.dataCapture.pojo.ActivityModel;
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
	public static ActivityModel getActModel(Post post, ActivityModel model) {

		switch (WebSiteConfig.WEB_SITE) {
		case 1:

			return teamActModel(post, model);
		case 2:

			return elevateActModel(post, model);
		case 3:

			return championActModel(post, model);

		default:

		}
		return null;
	}

	private static ActivityModel teamActModel(Post post, ActivityModel model) {
		List<String> param = getParam(post);
		switch (post.getParentId()) {
		case "4147a64f-35e3-4ac4-9c21-1bed795bd3ce":

			return model;
		case "0a6f2b04-c850-4668-9e39-a5ab7633f40e":

			return model;
		case "3":

			return model;
		case "4":

			return model;
		case "5":

			return model;

		default:
			return model;
		}
	}

	private static ActivityModel elevateActModel(Post post, ActivityModel model) {
		List<String> param = getParam(post);
		String json = null;
		switch (post.getParentId()) {

		// #FRIDAYFIVE: MY TOP 5 HTCS
		case "af048849-2625-4f12-9190-ded94464a956":
			model.setBody(param.get(0));
			json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name your list\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":3,\"maxLength\":30,\"responseMessage\":\"Between 3-30 characters, silly.\"},\"HtmlId\":\"11\",\"UUID\":\"a50a043d-e97f-484a-8933-b84dcb0e25c1\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Tell 'em about yo' five!\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":5,\"maxLength\":500,\"responseMessage\":\"Between 3-500 characters, yo.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"a50a043d-e97f-484a-8933-b84dcb0e25c1\",\"nodesText\":\"\",\"nodesIndex\":2}]";
			break;

		// ONE'S GOTTA GO: CLARIFICATION + SUBMIT YOUR OWN
		case "f3291cb2-5a9d-4945-84e1-843d08febe85":
			model.setBody(param.get(0));

			json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"What's Your Topic? (example: ice cream)\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":2,\"maxLength\":50,\"responseMessage\":\"Must be between 2-50 characters, ya'll.\"},\"HtmlId\":\"11\",\"UUID\":\"7af2b428-c6a4-4ffc-bf76-1f1db6c92bad\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Give me 2-3 options (example: chocolate, vanilla, strawberry)\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":2,\"maxLength\":140,\"responseMessage\":\"Must be between 2-140 characters. Verbosity is a friend to no one.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"7af2b428-c6a4-4ffc-bf76-1f1db6c92bad\",\"nodesText\":\"\",\"nodesIndex\":2}]";
			break;

		// #FOLLOWFRIDAY, ANYONE?
		case "565baea6-ea0b-4900-8a40-07d01f79b9df":

			json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"What's yo' name?\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":2,\"maxLength\":30,\"responseMessage\":\"Between 2 and 30 characters, ya'll.\"},\"HtmlId\":\"11\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Facebook?\",\"helpText\":\"http://www.facebook.com/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(0))
					+ "\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Twitter?\",\"helpText\":\"@YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(1))
					+ "\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Instagram?\",\"helpText\":\"@YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(2))
					+ "\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Pinterest?\",\"helpText\":\"http://www.pinterest.com/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(3))
					+ "\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Snapchat?\",\"helpText\":\"User name\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(4))
					+ "\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Tumblr?\",\"helpText\":\"http://YOURNAME.tumblr.com\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(5))
					+ "\",\"nodesIndex\":7},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Reddit?\",\"helpText\":\"https://www.reddit.com/user/YOURNAME\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(6))
					+ "\",\"nodesIndex\":8},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Blog?\",\"helpText\":\"Your URL, silly.\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(7))
					+ "\",\"nodesIndex\":9},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Other social?\",\"helpText\":\"Enter complete URL and/or username\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(8))
					+ "\",\"nodesIndex\":10},{\"Title\":\"Yes / No\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"You agree that HTC Elevate can share the above URLs and/or usernames from HTC Elevate social media. Your information will only be shared from HTC Elevate social media accounts.\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"13\",\"UUID\":\"b154c82c-f2bf-406e-a566-ecc25083dbc5\",\"nodesText\":\""
					+ replaceString(param.get(9).toLowerCase()) + "\",\"nodesIndex\":11}]";

			break;

		// [PHOTO SUBMISSION] WHAT'S GIVING YOU LIFE THIS WEEK?
		case "20f01de8-d8a0-47fc-a83a-cafff50ae6ce":
			model.setImageId(IMGuuid("1a138372-26ae-4a2f-9403-26fc582a731e", post.getImageUrl()));
			model.setBody(param.get(1));
			json = "[{\"Title\":\"Featured Image\",\"Type\":\"3\",\"Template\":\"/Module/PageInput\",\"NodesContent\":{\"qes\":\"Share your photo here\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"4\",\"UUID\":\"1a138372-26ae-4a2f-9403-26fc582a731e\",\"nodesText\":\"\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Tell us about your photo\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"1a138372-26ae-4a2f-9403-26fc582a731e\",\"nodesText\":\"\",\"nodesIndex\":2}]";
			post.setTitle(null);
			break;

		// HTC ELEVATE PREMIUM SUPPORT
		case "fc80c09d-1719-4dcd-8611-d0b8c29126a8":
			model.setBody(param.get(6));
			/*
			 * json =
			 * "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\"},\"HtmlId\":\"11\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + post.getTitle() +
			 * "\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Country\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(0)) +
			 * "\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Phone Model\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(1)) +
			 * "\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Serial Number\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(2)) +
			 * "\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"IMEI\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(3)) +
			 * "\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Contact Number\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(4)) +
			 * "\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Email\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
			 * + replaceString(param.get(5)) +
			 * "\",\"nodesIndex\":7},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Description of Problem\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"\",\"nodesIndex\":8}]}"
			 * ;
			 * 
			 */ json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\"},\"HtmlId\":\"11\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Country\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(0))
					+ "\",\"nodesIndex\":2},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Phone Model\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(1))
					+ "\",\"nodesIndex\":3},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Serial Number\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(2))
					+ "\",\"nodesIndex\":4},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"IMEI\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(3))
					+ "\",\"nodesIndex\":5},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Contact Number\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(4))
					+ "\",\"nodesIndex\":6},{\"Title\":\"Single Line Text\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Email\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"9\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\""
					+ replaceString(param.get(5))
					+ "\",\"nodesIndex\":7},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Description of Problem\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"2ede297d-956d-4339-9222-f6868884f74a\",\"nodesText\":\"\",\"nodesIndex\":8}]";

			break;
		default:

		}

		model.setDataList(json);
		return model;
	}

	private static ActivityModel championActModel(Post post, ActivityModel model) {
		List<String> param = getParam(post);
		String json = null;
		switch (post.getParentId()) {
		// #FridayFive: My Top 5 HTCs
		case "c8138e7b-3143-462d-9a2e-c48d091339b4":
			model.setBody(param.get(0));
			json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Name your list\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":3,\"maxLength\":30,\"responseMessage\":\"Between 3-30.\"},\"HtmlId\":\"11\",\"UUID\":\"fe2752b7-6ec3-425b-9c36-4af076d95025\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Tell 'em your five.\",\"helpText\":\"\",\"require\":false,\"requireText\":\"This field is required.\",\"restrict\":true,\"minLength\":3,\"maxLength\":280,\"responseMessage\":\"Between 3-280 characters\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"fe2752b7-6ec3-425b-9c36-4af076d95025\",\"nodesText\":\"\",\"nodesIndex\":2}]";
			break;
		// Show Your HTC Community Spirit
		case "44e1d8d1-acfe-47dc-893a-1f3be2aa5541":
			model.setBody(param.get(0));
			model.setImageId(IMGuuid("eb7f289c-b245-43b7-9597-0b7affd2b3b4", post.getImageUrl()));
			json = "[{\"Title\":\"Submission Title\",\"Type\":\"3\",\"Template\":\"/Module/SingleSelect\",\"NodesContent\":{\"qes\":\"Please give your photo a title.\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\"},\"HtmlId\":\"11\",\"UUID\":\"eb7f289c-b245-43b7-9597-0b7affd2b3b4\",\"nodesText\":\""
					+ post.getTitle()
					+ "\",\"nodesIndex\":1},{\"Title\":\"Description\",\"Type\":\"3\",\"Template\":\"/Module/Description\",\"NodesContent\":{\"qes\":\"Please tell us about your photo. Where did you take it, and what festival or event were you at? What makes this event special to you?\",\"helpText\":\"\",\"require\":true,\"requireText\":\"This field is required.\",\"restrict\":false,\"minLength\":0,\"maxLength\":1000,\"responseMessage\":\"\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"2\",\"UUID\":\"eb7f289c-b245-43b7-9597-0b7affd2b3b4\",\"nodesText\":\"\",\"nodesIndex\":2},{\"Title\":\"Image Upload\",\"Type\":\"3\",\"Template\":\"/Module/PageInput\",\"NodesContent\":{\"qes\":\"Please upload your image(s) from your event.\",\"helpText\":\"\",\"require\":true,\"requireText\":\"Please upload a photo.\",\"private\":false,\"hidePage\":false},\"HtmlId\":\"5\",\"UUID\":\"eb7f289c-b245-43b7-9597-0b7affd2b3b4\",\"nodesText\":\"\",\"nodesIndex\":3}]";
			break;
		default:
			break;
		}
		model.setDataList(json);
		return model;
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
			param.add(val);
		}

		return param;

	}

	// 设置图片id
	private static String IMGuuid(String uuid, String imgs) {
		String[] img = null;
		StringBuffer uuids = new StringBuffer();
		if (imgs != null && !imgs.equals("")) {
			img = imgs.split(",");

			for (String string : img) {
				uuids.append(uuid + ",");
			}
		}

		String UUIDS = uuids.toString();
		if (UUIDS != null && !UUIDS.equals("")) {
			UUIDS = UUIDS.substring(0, UUIDS.length() - 1);
		}

		return UUIDS;
	}

	// 去掉p标签
	private static String replaceString(String s) {
		return s.replace("<p>", "").replace("</p>", "");
	}
}
