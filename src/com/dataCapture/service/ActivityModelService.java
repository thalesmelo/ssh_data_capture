package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.ActivityModel;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月28日
 *
 * @TIME  上午11:56:41
 */
public interface ActivityModelService {

	void save(ActivityModel activityModel);

	void deleteAll();

	List<ActivityModel> queryAll();
		
	List<ActivityModel> queryByUUID(String uuid);
}
