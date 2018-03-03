package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Post;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月15日
 *
 * @TIME 下午4:17:02
 */
public interface ForumService {

	void save(Post post);

	void deleteAll();

	List<Post> queryAll();
	
	List<Post> queryByUUID(String uuid);
}
