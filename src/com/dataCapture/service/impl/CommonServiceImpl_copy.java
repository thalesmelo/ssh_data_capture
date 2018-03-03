package com.dataCapture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.CommonDao_Copy;
import com.dataCapture.pojo.Common_copy;
import com.dataCapture.service.CommonService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月8日
 *
 * @TIME  下午4:49:23
 */
@Service
public class CommonServiceImpl_copy implements CommonService_copy{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#save(com.dataCapture.pojo.Common)
	 */
	@Autowired
	private CommonDao_Copy dao;
	
	@Override
	public void save(Common_copy common) {
		// TODO Auto-generated method stub
		dao.saveForCopy(common);
	}

}
