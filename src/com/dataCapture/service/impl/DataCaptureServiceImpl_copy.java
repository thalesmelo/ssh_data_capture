package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.DataCaptureDao_Copy;
import com.dataCapture.pojo.News_copy;
import com.dataCapture.service.DataCaptureService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2017年10月9日
 *
 * @TIME  下午3:31:13
 */
@Service
public class DataCaptureServiceImpl_copy implements DataCaptureService_copy{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#save(com.dataCapture.pojo.Detail_info)
	 */
	@Autowired
	private DataCaptureDao_Copy dao;
	
	@Override
	public void save(News_copy info) {
		// TODO Auto-generated method stub
		dao.saveForCopy(info);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#queryAll()
	 */
	@Override
	public List<News_copy> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.DataCaptureService#queryById(java.lang.Integer)
	 */
	@Override
	public News_copy queryById(Class clazz,Integer id) {
		// TODO Auto-generated method stub
		return (News_copy) dao.queryById(clazz, id);
	}

}
