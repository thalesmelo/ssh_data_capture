package com.dataCapture.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月16日
 *
 * @TIME  下午4:22:29
 */
public class DateUtil {

	public static Date parseDateByString(String date){
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(date.replace("T", " ").replace("Z", " "));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();Progress.error=true;
		}
		System.err.println("时间格式错误!");
		return null;
	}
	
	public static Date parseDateByLong(long date){
		return parseDateByString(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date(date*1000)));
	}
}
