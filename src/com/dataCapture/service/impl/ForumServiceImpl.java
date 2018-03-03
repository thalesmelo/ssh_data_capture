package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.ForumDao;
import com.dataCapture.pojo.Post;
import com.dataCapture.service.ForumService;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月15日
 *
 * @TIME  下午4:18:21
 */
@Service
public class ForumServiceImpl implements ForumService{

	@Autowired
	private ForumDao dao;
	/* (non-Javadoc)
	 * @see com.dataCapture.service.ForumService#save(com.dataCapture.pojo.Post)
	 */
	@Override
	public void save(Post post) {
		// TODO Auto-generated method stub
		dao.save(post);
	}
	/* (non-Javadoc)
	 * @see com.dataCapture.service.ForumService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}
	/* (non-Javadoc)
	 * @see com.dataCapture.service.ForumService#queryAll()
	 */
	@Override
	public List<Post> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}
	/* (non-Javadoc)
	 * @see com.dataCapture.service.ForumService#queryByUUID(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		String hql=" From Post where ParentId like '%"+uuid+"%'";
		return dao.findByHql(hql);
	}

}
