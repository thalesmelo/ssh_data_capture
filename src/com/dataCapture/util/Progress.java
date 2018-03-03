package com.dataCapture.util;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月16日
 *
 * @TIME 上午10:07:20
 */
public class Progress {
	public static int proIndex = 0;
	public static int imgIndex = 0;
	public static int commonIndex = 0;
	public static int photoIndex = 0;
	public static int tagIndex = 0;
	public static Boolean error=false;

	public static void Progressing() {
		proIndex++;
		System.err.println("  正在加载 : " + proIndex + " 条数据!!!");
	}

	public static void imgProgressinng() {
		imgIndex++;
		System.err.println("  正在下载: " + imgIndex + " 张图片!!!");
	}

	public static void commonProgress() {
		commonIndex++;
		System.err.println("   正在加载: " + commonIndex + " 条评论!!!");
	}

	public static void photoProgress() {
		photoIndex++;
		System.err.println("   正在加载: " + photoIndex + " 个photoimg!!!");
	}

	public static void tagProgress() {
		tagIndex++;
		System.err.println("   正在加载: " + tagIndex + " 条tag!!!");
	}

	public static void resetProgress() {
		proIndex = 0;
		imgIndex = 0;
		commonIndex = 0;
		photoIndex = 0;
		tagIndex = 0;
	}
}
