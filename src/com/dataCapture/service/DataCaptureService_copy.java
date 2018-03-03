package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.News_copy;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:49:34
 */
public interface DataCaptureService_copy {

	void save(News_copy info);

	List<News_copy> queryAll();

	/**
	 * @param id
	 * @return
	 */
	News_copy queryById(Class clazz, Integer id);
}
