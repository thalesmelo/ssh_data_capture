package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Users;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月20日
 *
 * @TIME  上午10:42:43
 */
public interface UsersService {

	Users query(String uuid);
	
	void update(Users users);
	
	List<Users> findAll();
	
	List<Users> findByWebSite();
}
