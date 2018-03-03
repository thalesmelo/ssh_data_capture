package com.dataCapture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataCapture.dao.AlbumDao;
import com.dataCapture.dao.AlbumDao_Copy;
import com.dataCapture.pojo.Photos;
import com.dataCapture.pojo.Photos_copy;
import com.dataCapture.service.AlbumService;
import com.dataCapture.service.AlbumService_copy;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月24日
 *
 * @TIME  下午2:09:32
 */
@Service
public class AlbumServiceImpl_copy implements AlbumService_copy{
	
	@Autowired
	private AlbumDao_Copy dao;

	/* (non-Javadoc)
	 * @see com.dataCapture.service.AlbumService#save(com.dataCapture.pojo.Photos)
	 */
	@Override
	public void save(Photos_copy photos) {
		// TODO Auto-generated method stub
		dao.saveForCopy(photos);
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.AlbumService#findByWebsite()
	 */
	@Override
	public List<Photos_copy> findByWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.service.AlbumService#queryByUUID(java.lang.String)
	 */
	@Override
	public Photos_copy queryByUUID(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
