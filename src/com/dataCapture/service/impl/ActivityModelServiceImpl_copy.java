package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.ActivityModelDao;
import com.dataCapture.dao.ActivityModelDao_copy;
import com.dataCapture.pojo.ActivityModel;
import com.dataCapture.pojo.ActivityModel_copy;
import com.dataCapture.service.ActivityModelService;
import com.dataCapture.service.ActivityModelService_copy;

/**
 * @author zhuCan
 *
 * @DATE 2018年2月28日
 *
 * @TIME 上午11:57:08
 */
@Service
public class ActivityModelServiceImpl_copy implements ActivityModelService_copy {

	@Autowired
	private ActivityModelDao_copy dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dataCapture.service.ActivityModelService#save(com.dataCapture.pojo.
	 * ActivityModel)
	 */
	@Override
	public void save(ActivityModel_copy activityModel) {
		// TODO Auto-generated method stub
		dao.saveForCopy(activityModel);;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.ActivityModelService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.ActivityModelService#queryAll()
	 */
	@Override
	public List<ActivityModel_copy> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.ActivityModelService#queryByUUID(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityModel_copy> queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		String hql = " From ActivityModel where UUID like '%" + uuid + "%'";
		return (List<ActivityModel_copy>) dao.queryByUUID(hql);
	}

}
