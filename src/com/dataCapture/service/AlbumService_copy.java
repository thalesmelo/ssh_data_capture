package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Photos;
import com.dataCapture.pojo.Photos_copy;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:08:45
 */
public interface AlbumService_copy {

	void save(Photos_copy photos);
	
	List<Photos_copy> findByWebsite();
	
	Photos_copy queryByUUID(String uuid);
}
