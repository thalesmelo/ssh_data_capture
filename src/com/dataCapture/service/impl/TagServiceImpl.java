package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.TagDao;
import com.dataCapture.pojo.Tags;
import com.dataCapture.service.TagService;
import com.dataCapture.util.Progress;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月16日
 *
 * @TIME  上午11:48:11
 */
@Service
public class TagServiceImpl implements TagService{

	@Autowired
	private TagDao dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.TagService#save(com.dataCapture.pojo.Tag)
	 */
	@Override
	public void save(Tags tag) {
		// TODO Auto-generated method stub
		Progress.tagProgress();
		dao.save(tag);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.TagService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.TagService#queryAll()
	 */
	@Override
	public List<Tags> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}
}