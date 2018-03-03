package com.dataCapture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.ForumDao;
import com.dataCapture.dao.ForumDao_Copy;
import com.dataCapture.pojo.Post;
import com.dataCapture.pojo.Post_copy;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.ForumService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月15日
 *
 * @TIME  下午4:18:21
 */
@Service
public class ForumServiceImpl_copy implements ForumService_copy{

	@Autowired
	private ForumDao_Copy dao;
	/* (non-Javadoc)
	 * @see com.dataCapture.service.ForumService#save(com.dataCapture.pojo.Post)
	 */
	@Override
	public void save(Post_copy post) {
		// TODO Auto-generated method stub
		dao.saveForCopy(post);
	}

}
