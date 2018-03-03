package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.CommonDao;
import com.dataCapture.pojo.Common;
import com.dataCapture.service.CommonService;
import com.dataCapture.util.Progress;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月8日
 *
 * @TIME  下午4:49:23
 */
@Service
public class CommonServiceImpl implements CommonService{

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#save(com.dataCapture.pojo.Common)
	 */
	@Autowired
	private CommonDao dao;
	
	@Override
	public void save(Common common) {
		// TODO Auto-generated method stub
		Progress.commonProgress();
		dao.save(common);
		
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#queryAll()
	 */
	@Override
	public List<Common> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#findByParent(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Common> findByParent(String parentUUID) {
		// TODO Auto-generated method stub
		String hql=" From Common where Parent like '%"+parentUUID+"%'";
		return   dao.findByHql(hql);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#replyByParent(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Common> replyByParent(String replyUUID) {
		// TODO Auto-generated method stub
		String hql=" From Common where ReplyId like '%"+replyUUID+"%'";
		return  dao.findByHql(hql);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.CommonService#queryByUUID(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Common> queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		String hql=" From Common where ActivityId like '%"+uuid+"%'";
		return dao.findByHql(hql);
	}

}
