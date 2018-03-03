package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.News;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:49:34
 */
public interface DataCaptureService {

	void save(News info);

	List<News> queryAll();

	/**
	 * @param id
	 * @return
	 */
	News queryById(Class clazz, Integer id);
	
	void deleteAll();
	
	List<News> allByWebSite();
}
