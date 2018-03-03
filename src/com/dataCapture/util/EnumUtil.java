package com.dataCapture.util;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.Enum.WebSite;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月30日
 *
 * @TIME 下午3:31:02
 */
public class EnumUtil {

	public static WebSite getWebSite(Integer website) {
		switch (website) {
		case 1:
			return WebSite.TEAM;

		case 2:
			return WebSite.ELEVATE;

		case 3:
			return WebSite.CHAMPIONS;

		default:
			break;
		}
		return null;
	}

	public static WebModule getModule(Integer module) {
		switch (module) {
		case 1:
			return WebModule.NEWS;
		case 2:
			return WebModule.TRAINING;
		case 3:
			return WebModule.DISSCUSSION;
		case 4:
			return WebModule.ACTIVITY;
		case 5:
			return WebModule.PHOTO;
		case 6:
			return WebModule.USER;
		default:
			break;
		}

		return null;
	}
}
