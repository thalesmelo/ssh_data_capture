package com.dataCapture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.TagDao;
import com.dataCapture.dao.TagDao_Copy;
import com.dataCapture.pojo.Tags;
import com.dataCapture.pojo.Tags_copy;
import com.dataCapture.service.TagService;
import com.dataCapture.service.TagService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月16日
 *
 * @TIME  上午11:48:11
 */
@Service
public class TagServiceImpl_copy implements TagService_copy{

	@Autowired
	private TagDao_Copy dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.TagService#save(com.dataCapture.pojo.Tag)
	 */
	@Override
	public void save(Tags_copy tag) {
		// TODO Auto-generated method stub
		dao.saveForCopy(tag);
	}
}