package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.pojo.PhotosImg_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月24日
 *
 * @TIME  下午2:09:09
 */
public interface PhotoService_copy {

	void save(PhotosImg_copy img);
	
	List<PhotosImg_copy> findByWebsite();
	
	PhotosImg_copy findByUUID(String uuid);
}
