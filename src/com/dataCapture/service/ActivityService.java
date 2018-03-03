package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Activity;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月7日
 *
 * @TIME  上午10:00:19
 */
public interface ActivityService {

	Activity queryByUUID(String uuid);
	
	void update(Activity activity);
	
	List<Activity> findALL();
	
	
}
