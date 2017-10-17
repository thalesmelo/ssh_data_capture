package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Detail_info;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:49:34
 */
public interface DataCaptureService {

	void save(Detail_info info);

	List<Detail_info> queryAll();

	/**
	 * @param id
	 * @return
	 */
	Detail_info queryById(Class clazz, Integer id);
}
