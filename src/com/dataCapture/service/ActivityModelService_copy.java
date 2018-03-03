package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.ActivityModel;
import com.dataCapture.pojo.ActivityModel_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月28日
 *
 * @TIME  上午11:56:41
 */
public interface ActivityModelService_copy {

	void save(ActivityModel_copy activityModel);

	void deleteAll();

	List<ActivityModel_copy> queryAll();
		
	List<ActivityModel_copy> queryByUUID(String uuid);
}
