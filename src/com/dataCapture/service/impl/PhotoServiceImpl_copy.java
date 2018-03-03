package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.PhotoDao;
import com.dataCapture.dao.PhotoDao_Copy;
import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.pojo.PhotosImg_copy;
import com.dataCapture.service.PhotoService;
import com.dataCapture.service.PhotoService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月24日
 *
 * @TIME  下午2:11:34
 */
@Service
public class PhotoServiceImpl_copy implements PhotoService_copy{
	
	@Autowired
	private PhotoDao_Copy dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#save(com.dataCapture.pojo.PhotosImg)
	 */
	@Override
	public void save(PhotosImg_copy img) {
		// TODO Auto-generated method stub
		dao.saveForCopy(img);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#findByWebsite()
	 */
	@Override
	public List<PhotosImg_copy> findByWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#findByUUID(java.lang.String)
	 */
	@Override
	public PhotosImg_copy findByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
