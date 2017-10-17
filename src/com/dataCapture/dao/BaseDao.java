package com.dataCapture.dao;

import java.util.List;

/**
 * @author zhuCan
 *
 * @DATE  2017年10月9日
 *
 * @TIME  下午2:56:03
 */
public interface BaseDao<T> {

	public void save(T instance);
	public List<T> query();
	
	public Object queryById(Class clazz,Integer id);
}
