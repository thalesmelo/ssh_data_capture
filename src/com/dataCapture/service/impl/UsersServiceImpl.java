package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.UsersDao;
import com.dataCapture.pojo.Users;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月20日
 *
 * @TIME  上午10:43:58
 */
@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.UsersService#query(java.lang.String)
	 */

	@Override
	public Users query(String uuid) {
		// TODO Auto-generated method stub
		String hql=" from Users where UUID like '%"+uuid+"%'";
		/*List<Users> list=dao.findByHql(hql);
		if (list!=null&&!list.isEmpty()) {
			return list.get(0);
		}*/
		return (Users) dao.queryByUUID(hql);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.UsersService#update(com.dataCapture.pojo.Users)
	 */
	@Override
	public void update(Users users) {
		// TODO Auto-generated method stub
		dao.update(users);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.UsersService#findAll()
	 */
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.UsersService#findByWebSite()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findByWebSite() {
		// TODO Auto-generated method stub
		String hql=" from Users where  WebsiteName="+WebSiteConfig.WEB_SITE;
		
		return dao.findByHql(hql);
	}

}
