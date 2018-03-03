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
		List<String> param=getParam(post);
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
		List<String> param=getParam(post);
		switch (post.getParentId()) {
		case "af048849-2625-4f12-9190-ded94464a956":

			return "";
		case "f3291cb2-5a9d-4945-84e1-843d08febe85":

			return "";
		case "565baea6-ea0b-4900-8a40-07d01f79b9df":

			return "";
		case "20f01de8-d8a0-47fc-a83a-cafff50ae6ce":

			return "";
		case "fc80c09d-1719-4dcd-8611-d0b8c29126a8":

			return "";

		default:
			return "";
		}
	}

	private static String championActModel(Post post) {
		List<String> param=getParam(post);
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
	
	
	private static List<String> getParam(Post post){
		List<String> param=new ArrayList<>();
	
		String html=post.getBody();
		String[] item=html.split("<h4 class=\"h4 \">");
		for (int i = 1; i < item.length; i++) {
			String val=item[i].substring(item[i].indexOf("</h4>")+5, item[i].length());
			if (i==item.length-1) {
				val=val.replace("</body>","").replace("</html>", "");
			}
		}
		
		return param;
		
	}
}
