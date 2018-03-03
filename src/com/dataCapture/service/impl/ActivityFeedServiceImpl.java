package com.dataCapture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.ActivityFeedDao;
import com.dataCapture.pojo.ActivityFeed;
import com.dataCapture.service.ActivityFeedService;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月6日
 *
 * @TIME  下午4:50:08
 */
@Service
public class ActivityFeedServiceImpl implements ActivityFeedService{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.ActivityFeedService#save(com.dataCapture.pojo.ActivityFeed)
	 */
	
	@Autowired
	private ActivityFeedDao dao;
	
	@Override
	public void save(ActivityFeed activityFeed) {
		// TODO Auto-generated method stub
		dao.save(activityFeed);
		
	}

}
