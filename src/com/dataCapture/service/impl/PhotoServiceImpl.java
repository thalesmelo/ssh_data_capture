package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.PhotoDao;
import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.service.PhotoService;
import com.dataCapture.util.Progress;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月24日
 *
 * @TIME  下午2:11:34
 */
@Service
public class PhotoServiceImpl implements PhotoService{
	
	@Autowired
	private PhotoDao dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#save(com.dataCapture.pojo.PhotosImg)
	 */
	@Override
	public void save(PhotosImg img) {
		// TODO Auto-generated method stub
		Progress.photoProgress();
		dao.save(img);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#findByWebsite()
	 */
	@Override
	public List<PhotosImg> findByWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#findByUUID(java.lang.String)
	 */
	@Override
	public PhotosImg findByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.PhotoService#queryAll()
	 */
	@Override
	public List<PhotosImg> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

}
