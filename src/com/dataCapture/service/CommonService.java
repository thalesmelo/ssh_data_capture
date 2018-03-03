package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Common;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月8日
 *
 * @TIME 下午4:48:49
 */
public interface CommonService {

	void save(Common common);

	void deleteAll();

	List<Common> queryAll();
	
	List<Common> findByParent(String parentUUID);
		
	List<Common> replyByParent(String replyUUID);
	
	List<Common> queryByUUID(String uuid);
	
}
