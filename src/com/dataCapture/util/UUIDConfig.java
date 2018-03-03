package com.dataCapture.util;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月16日
 *
 * @TIME 上午10:12:26
 */
public class UUIDConfig {

	/*
	 * // champion的参数 public final static String[] UUIDS = {
	 * "db2efbd8-204b-4a35-9374-d6de9dcab047",
	 * "349c1e1f-c7a2-45a9-a8cc-965c7bf38dce",
	 * "77c63842-7ec3-4949-93da-d60ec034b455",
	 * "31a2213f-c423-4cdf-bf12-3380e2a7744d",
	 * "0d3b720f-f4a0-4178-9b47-8ac725f2e4a1",
	 * "a42c1d78-c151-4dbc-8a8b-f8c89f93c665",
	 * "2ac4c7cb-a9ff-4fc9-87d8-c8fe99e94948",
	 * "b7f17003-52d6-4381-88e4-e581d5ea11ac",
	 * "9ff11494-eee1-4d4e-aa16-9820913ae8c9",
	 * "44e1d8d1-acfe-47dc-893a-1f3be2aa5541" };
	 * 
	 * public static String[] Titles = { "Forums", "Status Feed",
	 * "Introduce yourself and get to know other members!",
	 * "HTC Champions Silver/Gold/Champion Hangout!",
	 * "Video: Android 7.0 Nougat on HTC One A9!",
	 * "Video: Top 5 Features of the HTC 10!", "Video: HTC Bolt vs. HTC 10!",
	 * "Video: Android 7.0 Nougat on HTC 10!", "VIP Spotlight!",
	 * "Show Your HTC Community Spirit" };
	 * 
	 * public static String[] FILE_NAME = {
	 * "activities/3/HTC Champions - Forums.html",
	 * "activities/3/HTC Champions - Status Feed.html",
	 * "activities/3/HTC Champions - Introduce yourself and get to know other members!.html"
	 * ,
	 * "activities/3/HTC Champions - HTC Champions Silver_Gold_Champion Hangout!.html"
	 * ,
	 * "activities/3/HTC Champions - Video_ Android 7.0 Nougat on HTC One A9!.html"
	 * ,
	 * "activities/3/HTC Champions - Video_ Top 5 Features of the HTC 10!.html",
	 * "activities/3/HTC Champions - Video_ HTC Bolt vs. HTC 10!.html",
	 * "activities/3/HTC Champions - Video_ Android 7.0 Nougat on HTC 10!.html",
	 * "activities/3/HTC Champions - VIP Spotlight!.html",
	 * "activities/3/HTC Champions - Show Your HTC Community Spirit.html" };
	 */
	// 存放activities的 title&uuid&filename的 二维数组
	public static String[][] Activities_infos_Champions = {
			{ "Forums", "db2efbd8-204b-4a35-9374-d6de9dcab047", "activities/3/HTC Champions - Forums.html" },

			{ "Status Feed", "349c1e1f-c7a2-45a9-a8cc-965c7bf38dce", "activities/3/HTC Champions - Status Feed.html" },

			{ "Introduce yourself and get to know other members!", "77c63842-7ec3-4949-93da-d60ec034b455",
					"activities/3/HTC Champions - Introduce yourself and get to know other members!.html" },

			{ "HTC Champions Silver/Gold/Champion Hangout!", "31a2213f-c423-4cdf-bf12-3380e2a7744d",
					"activities/3/HTC Champions - HTC Champions Silver_Gold_Champion Hangout!.html" },

			{ "Video: Android 7.0 Nougat on HTC One A9!", "0d3b720f-f4a0-4178-9b47-8ac725f2e4a1",
					"activities/3/HTC Champions - Video_ Android 7.0 Nougat on HTC One A9!.html" },

			{ "Video: Top 5 Features of the HTC 10!", "a42c1d78-c151-4dbc-8a8b-f8c89f93c665",
					"activities/3/HTC Champions - Video_ Top 5 Features of the HTC 10!.html" },

			{ "Video: HTC Bolt vs. HTC 10!", "2ac4c7cb-a9ff-4fc9-87d8-c8fe99e94948",
					"activities/3/HTC Champions - Video_ HTC Bolt vs. HTC 10!.html" },

			{ "Video: Android 7.0 Nougat on HTC 10!", "b7f17003-52d6-4381-88e4-e581d5ea11ac",
					"activities/3/HTC Champions - Video_ Android 7.0 Nougat on HTC 10!.html" },

			{ "VIP Spotlight!", "9ff11494-eee1-4d4e-aa16-9820913ae8c9",
					"activities/3/HTC Champions - VIP Spotlight!.html" },

			{ "Show Your HTC Community Spirit", "44e1d8d1-acfe-47dc-893a-1f3be2aa5541",
					"activities/3/HTC Champions - Show Your HTC Community Spirit.html" },

			{ "#FridayFive: My Top 5 HTCs", "c8138e7b-3143-462d-9a2e-c48d091339b4",
					"activities/3/HTC Champions - FridayFive: My Top 5 HTCs.html" } };

	// 存放 elevate 的二维数组
	public static String[][] Activities_infos_Elevate = { { "#FollowFriday, anyone?",
			"565baea6-ea0b-4900-8a40-07d01f79b9df", "activities/2/HTC elevate - #FollowFriday, anyone_.html" },

			{ "Elevate Elite Task Force: HTC U11", "e873f1ba-8a4e-46ca-ba33-ebe317fc0375",
					"activities/2/HTC elevate - Elevate Elite Task Force_ HTC U11.html" },

			{ "Elevate Gold Member Hangout!", "df99b636-aa3a-479e-9ad6-63e278aa48bb",
					"activities/2/HTC elevate - Elevate Gold Member Hangout!.html" },

			{ "Ultimate Elevater Private Hangout!", "3dca4a9f-9438-4388-a5e5-acb29deb0f68",
					"activities/2/HTC elevate - Ultimate Elevater Private Hangout!.html" },

			{ "[Photo submission] What's giving you ...", "20f01de8-d8a0-47fc-a83a-cafff50ae6ce",
					"activities/2/HTC elevate - [Photo submission] What's giving you life this week_.html" },

			{ "Elevate Chat Room: Europe", "d03b7af7-439e-4930-9c48-98cfa960c2ae",
					"activities/2/HTC elevate - Elevate Chat Room_ Europe.html" },

			{ "Elevate Chat Room: Australia/New Zealand", "619ea5d5-bfb0-447f-8e22-5d6c126b846e",
					"activities/2/HTC elevate - Elevate Chat Room_ Australia_New Zealand.html" },

			{ "Elevate Chat Room: South Asia", "46075d6d-8118-4946-b0af-c85fd0c0daa0",
					"activities/2/HTC elevate - Elevate Chat Room_ South Asia.html" },

			{ "Elevate Chat Room: Americas", "aa10d908-3e0a-4dec-b69d-14f4705e84f6",
					"activities/2/HTC elevate - Elevate Chat Room_ Americas.html" },

			{ "Elevate Chat Room: India", "9dbed0d2-5f71-43c9-8218-3dac5c23be19",
					"activities/2/HTC elevate - Elevate Chat Room_ India.html" },

			{ "Elevate Coffee Shop", "46c75d93-746d-443e-90e4-0dcff2282e51",
					"activities/2/HTC elevate - Elevate Coffee Shop.html" },

			{ "Want to be featured on HTC's social ...", "8adac01b-5211-4261-a17a-3d0cea4bec53",
					"activities/2/HTC elevate - Want to be featured on HTC's social channels_.html" },

			{ "What was your first HTC smartphone?", "cb576995-a45e-485a-a22b-8e02cc2d841c",
					"activities/2/HTC elevate - What was your first HTC smartphone_.html" },

			{ "Forums", "8087353f-186a-4f88-8091-4619c1fe83d4", "activities/2/HTC elevate - Forums.html" },

			{ "Video: Camera modes on HTC U Ultra!", "0cd2e78d-2f15-498d-9a23-6ad2cb969f5c",
					"activities/2/HTC elevate - Video_ Camera modes on HTC U Ultra!.html" },

			{ "Introduce Yourself and Get to Know ...", "49dee2f4-af95-42db-ac97-1cb9de293471",
					"activities/2/HTC elevate - Introduce Yourself and Get to Know Other Members.html" },

			{ "Member Help and How To", "de80b478-d8f8-427d-93ec-d3f3df376c6d",
					"activities/2/HTC elevate - Member Help and How To.html" },

			{ "HTC Elevate Premium Support", "fc80c09d-1719-4dcd-8611-d0b8c29126a8",
					"activities/2/HTC elevate - HTC Elevate Premium Support.html" },

			{ "Platform Training Videos", "0cfd0c05-772d-41e7-bace-8ecc14c1c26f",
					"activities/2/HTC elevate - Platform Training Videos.html" },

			{ "#FridayFive: My Top 5 HTCs", "af048849-2625-4f12-9190-ded94464a956",
					"activities/2/HTC elevate - #FridayFive: My Top 5 HTCs.html" },

			{ "One's Gotta Go: Clarification + Submit ...", "f3291cb2-5a9d-4945-84e1-843d08febe85",
					"activities/2/HTC elevate - One's Gotta Go: Clarification + Submit ..." } };

	// team的二维数组
	public static String[][] Activities_info_team = {
			{ "Introduce Yourself and Get to Know ...", "b0096172-c5df-480f-a67c-77625dfceff6",
					"activities/1/Team HTC - Introduce Yourself and Get to Know Other Members.html" },

			{ "Unboxing: HTC U11!", "5595b497-7bad-49ac-af1d-7d280be8c384",
					"activities/1/Team HTC - Unboxing_ HTC U11!.html" },

			{ "Gold and Team Captain Private Chat Room!", "bbfe322f-9fe9-47e0-a4e5-1af784f57bca",
					"activities/1/Team HTC - Gold and Team Captain Private Chat Room!.html" },

			{ "Opening a new HTC smartphone box is ...", "0a6f2b04-c850-4668-9e39-a5ab7633f40e",
					"activities/1/Team HTC - Opening a new HTC smartphone box is most like....html" },

			{ "Unboxing: HTC U Ultra!", "dbe9399a-0989-4e93-987b-f963664222f2",
					"activities/1/Team HTC - Unboxing_ HTC U Ultra!.html" },

			{ "What was Your First HTC Phone?", "d59b8e78-2198-464c-be5e-6b443c228b19",
					"activities/1/Team HTC - What was Your First HTC Phone_.html" },

			{ "Forums", "7d2d754d-57ca-4afe-91df-e1a30628ae23", "activities/1/Team HTC - Forums.html" },

			{ "Platform Training Videos", "e230e896-cb00-4e1e-81a4-11d096216af4",
					"activities/1/Team HTC - Platform Training Videos.html" },

			{ "#FridayFive: My Top 5 HTCs", "4147a64f-35e3-4ac4-9c21-1bed795bd3ce",
					"activities/1/Team HTC - #FridayFive_ My Top 5 HTCs.html" } };

	/*
	 * // elevate的参数 public final static String[] UUID_ELEVATE = { "1", "2",
	 * "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
	 * "16", "17", "18", "19" };
	 * 
	 * public static String[] Titles_Elevate = { "#FollowFriday, anyone?",
	 * "Elevate Elite Task Force: HTC U11", "Elevate Gold Member Hangout!",
	 * "Ultimate Elevater Private Hangout!",
	 * "[Photo submission] What's giving you ...", "Elevate Chat Room: Europe",
	 * "Elevate Chat Room: Australia/New Zealand",
	 * "Elevate Chat Room: South Asia", "Elevate Chat Room: Americas",
	 * "Elevate Chat Room: India", "Elevate Coffee Shop",
	 * "Want to be featured on HTC's social ...",
	 * "What was your first HTC smartphone?", "Forums",
	 * "Video: Camera modes on HTC U Ultra!",
	 * "Introduce Yourself and Get to Know ...", "Member Help and How To",
	 * "HTC Elevate Premium Support", "Platform Training Videos" };
	 * 
	 * public static String[] File_Name = {
	 * "activities/2/HTC elevate - #FollowFriday, anyone_.html",
	 * "activities/2/HTC elevate - Elevate Elite Task Force_ HTC U11.html",
	 * "activities/2/HTC elevate - Elevate Gold Member Hangout!.html",
	 * "activities/2/HTC elevate - Ultimate Elevater Private Hangout!.html",
	 * "activities/2/", "activities/2/", "activities/2/", "activities/2/",
	 * "activities/2/", "activities/2/", "activities/2/", "activities/2/",
	 * "activities/2/", "activities/2/", "activities/2/", "activities/2/",
	 * "activities/2/", "activities/2/", "activities/2/", };
	 */
	// 获取固定的uuid
	public static String getActivityUUID(String title) {
		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			for (int i = 0; i < Activities_infos_Champions.length; i++) {
				if (title.contains(Activities_infos_Champions[i][0])
						|| Activities_infos_Champions[i][0].contains(title)) {
					return Activities_infos_Champions[i][1];
				}
			}
			break;
		case 2:
			for (int i = 0; i < Activities_infos_Elevate.length; i++) {
				if (title.contains(Activities_infos_Elevate[i][0]) || Activities_infos_Elevate[i][0].contains(title)) {
					return Activities_infos_Elevate[i][1];
				}
			}
			break;
		case 1:
			for (int i = 0; i < Activities_info_team.length; i++) {
				if (title.contains(Activities_info_team[i][0]) || Activities_info_team[i][0].contains(title)) {
					return Activities_info_team[i][1];
				}
			}
			break;
		default:
			break;
		}

		System.err.println("输入的标题有误!");
		return null;
	}

	// 获取file 的name
	public static String getFileName(String title) {

		switch (WebSiteConfig.WEB_SITE) {
		case 3:
			for (int i = 0; i < Activities_infos_Champions.length; i++) {
				if (title.contains(Activities_infos_Champions[i][0])
						|| Activities_infos_Champions[i][0].contains(title)) {
					return Activities_infos_Champions[i][2];
				}
			}
			break;
		case 2:
			for (int i = 0; i < Activities_infos_Elevate.length; i++) {
				if (title.contains(Activities_infos_Elevate[i][0]) || Activities_infos_Elevate[i][0].contains(title)) {
					return Activities_infos_Elevate[i][2];
				}
			}
			break;
		case 1:
			for (int i = 0; i < Activities_info_team.length; i++) {
				if (title.contains(Activities_info_team[i][0]) || Activities_info_team[i][0].contains(title)) {
					return Activities_info_team[i][2];
				}
			}
			break;

		default:
			break;
		}

		System.err.println("输入的标题有误!");
		return null;
	}
}
