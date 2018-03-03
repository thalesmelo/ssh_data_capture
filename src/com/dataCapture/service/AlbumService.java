package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Photos;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:08:45
 */
public interface AlbumService {

	void save(Photos photos);
	
	List<Photos> findByWebsite();
	
	Photos queryByUUID(String uuid);
	
	void deleteAll();
	
	List<Photos> queryAll();
}
