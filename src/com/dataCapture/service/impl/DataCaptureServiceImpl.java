package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.DataCaptureDao;
import com.dataCapture.pojo.Detail_info;
import com.dataCapture.service.DataCaptureService;

/**
 * @author zhuCan
 *
 * @DATE  2017年10月9日
 *
 * @TIME  下午3:31:13
 */
@Service
public class DataCaptureServiceImpl implements DataCaptureService{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#save(com.dataCapture.pojo.Detail_info)
	 */
	@Autowired
	private DataCaptureDao dao;
	
	@Override
	public void save(Detail_info info) {
		// TODO Auto-generated method stub
		dao.save(info);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#queryAll()
	 */
	@Override
	public List<Detail_info> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#queryById(java.lang.Integer)
	 */
	@Override
	public Detail_info queryById(Class clazz,Integer id) {
		// TODO Auto-generated method stub
		return (Detail_info) dao.queryById(clazz, id);
	}

}
