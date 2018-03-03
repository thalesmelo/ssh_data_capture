package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.ActivityDao;
import com.dataCapture.pojo.Activity;
import com.dataCapture.service.ActivityService;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月7日
 *
 * @TIME  上午10:02:50
 */
@Service
public class ActivityServiceImpl implements ActivityService{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.ActivityService#queryByUUID(java.lang.String)
	 */
	
	@Autowired
	private ActivityDao dao;
	
	@Override
	public Activity queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		String hql=" From Activity where UUID like '%"+uuid+"'";
		
		return (Activity) dao.queryByUUID(hql);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.ActivityService#update(com.dataCapture.pojo.Activity)
	 */
	@Override
	public void update(Activity activity) {
		// TODO Auto-generated method stub
		dao.update(activity);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.ActivityService#findALL()
	 */
	@Override
	public List<Activity> findALL() {
		// TODO Auto-generated method stub
		return dao.query();
	}

}
