package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.PhotosImg;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:09:09
 */
public interface PhotoService {

	void save(PhotosImg img);

	List<PhotosImg> findByWebsite();

	PhotosImg findByUUID(String uuid);

	void deleteAll();

	List<PhotosImg> queryAll();
}
