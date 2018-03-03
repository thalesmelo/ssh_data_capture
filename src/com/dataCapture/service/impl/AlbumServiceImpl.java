package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.AlbumDao;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.Photos;
import com.dataCapture.pojo.Post;
import com.dataCapture.service.AlbumService;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:09:32
 */
@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dataCapture.service.AlbumService#save(com.dataCapture.pojo.Photos)
	 */
	@Override
	public void save(Photos photos) {
		// TODO Auto-generated method stub
		dao.save(photos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.AlbumService#findByWebsite()
	 */
	@Override
	public List<Photos> findByWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.AlbumService#queryByUUID(java.lang.String)
	 */
	@Override
	public Photos queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.AlbumService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.service.AlbumService#queryAll()
	 */
	@Override
	public List<Photos> queryAll() {
		// TODO Auto-generated method stub
		return dao.query();
	}

}
