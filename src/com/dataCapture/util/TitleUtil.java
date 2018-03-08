package com.dataCapture.util;

import com.dataCapture.Enum.WebSite;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月22日
 *
 * @TIME 上午11:58:36
 */
public class TitleUtil {

	/**
	 * disscussion的标题数组
	 **/

	// champion
	public static String[] Titles_champion_dis = { "Status Feed",
			"Introduce yourself and get to know other members!", "HTC Champions Silver/Gold/Champion Hangout!",
			"Video: Android 7.0 Nougat on HTC One A9!", "Video: Top 5 Features of the HTC 10!",
			"Video: HTC Bolt vs. HTC 10!", "Video: Android 7.0 Nougat on HTC 10!", "Forums" };

	// elevate
	public static String[] titles_elevate_dis = { "Elevate Elite Task Force: HTC U11", "Elevate Gold Member Hangout!",
			"Ultimate Elevater Private Hangout!", "Elevate Chat Room: Europe",
			"Elevate Chat Room: Australia/New Zealand", "Elevate Chat Room: South Asia", "Elevate Chat Room: Americas",
			"Elevate Chat Room: India", "Elevate Coffee Shop", "Want to be featured on HTC's social ...",
			"What was your first HTC smartphone?", "Video: Camera modes on HTC U Ultra!",
			"Introduce Yourself and Get to Know ...", "Member Help and How To", "Forums", "Platform Training Videos" };
	// team
    public  static String[] title_team_dis={"Introduce Yourself and Get to Know ...","Unboxing: HTC U11!",
    		"Gold and Team Captain Private Chat Room!","Unboxing: HTC U Ultra!","What was Your First HTC Phone?"
    		,"Forums","Platform Training Videos"};
	/**
	 * activities的标题数组
	 **/
	// champion
	public static String[] Titles_champion = { "VIP Spotlight!", "Show Your HTC Community Spirit" };

	// elevate
	public static String[] titles_elevate = { "#FridayFive: My Top 5 HTCs","One's Gotta Go: Clarification + Submit ...","#FollowFriday, anyone?", "[Photo submission] What's giving you ...",
			"HTC Elevate Premium Support" };
	// team
    public static String [] titles_team={"Opening a new HTC smartphone box is ..."};	
	
	
	// 获取discussion的标题
	public static String getDis_Title(WebSite webSite, int index) {
		switch (webSite) {
		case CHAMPIONS:
			return Titles_champion_dis[index - 1];
		case ELEVATE:
			return titles_elevate_dis[index - 1];
		case TEAM:
			return title_team_dis[index-1];
		default:
			break;
		}
		return null;

	}

	//获取activities的标题
	public static String getACT_Title(WebSite webSite, int index) {
		switch (webSite) {
		case CHAMPIONS:
			return Titles_champion[index - 1];
		case ELEVATE:
			return titles_elevate[index - 1];
		case TEAM:
			return titles_team[index-1];
		default:
			break;
		}
		return null;
	}

}
