package com.dataCapture.dao;

import java.util.List;

import com.dataCapture.pojo.News;

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
	
	public void saveForCopy(T instance);
	
	public Object queryById(Class clazz,Integer id);
	
	public void update(T instances);
	
	public void deleteAll();
	
	@SuppressWarnings("rawtypes")
	public List findByHql(String hql);

	/**
	 * 根据对象名和对象属性获取对象集合
	 * 
	 * @param className
	 * @param propertyName
	 * @param value
	 * @return
	 */
	
	public Object queryByUUID(String hql);
}
