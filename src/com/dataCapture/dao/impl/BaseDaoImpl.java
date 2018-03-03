package com.dataCapture.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dataCapture.dao.BaseDao;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:59:42
 */
@Component
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Log log = LogFactory.getLog(this.getClass());
	private Class<T> entityClass1;
	private String entityClass;
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		Class class1 = this.getClass();
		Type type = class1.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] pTypes = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass1 = (Class<T>) pTypes[0];
			entityClass = entityClass1.getName();
		}
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.dao.BaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T instance) {
		// TODO Auto-generated method stub
		log.debug("saving" + instance + "instance");
		try {
			hibernateTemplate.save(instance);
			
			log.debug("ok");
		} catch (RuntimeException exception) {
			log.error(exception);
			throw exception;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.dao.BaseDao#query()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> query() {
		// TODO Auto-generated method stub

		String hql = " FROM  " + entityClass;
		try {
			Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
			
			return query.list();
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dataCapture.dao.BaseDao#queryById(java.lang.Class,
	 * java.lang.Integer)
	 */
	@Override
	public Object queryById(Class clazz, Integer id) {
		// TODO Auto-generated method stub
		try {
			Object object = hibernateTemplate.get(clazz.getName(), id);
			
			return object;
		} catch (RuntimeException exception) {
			throw exception;
		}
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T instance) {
		log.debug("updating " + instance + " instance");
		try {
			hibernateTemplate.update(instance);
		
			log.debug("update successful");
		} catch (RuntimeException re) {

			log.error("update failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#findByHql(java.lang.String)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List findByHql(String hql) {
		log.debug(hql);
		try {
			Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by HQL ", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#queryByUUID(java.lang.String)
	 */
	@Override
	public Object queryByUUID(String hql) {
		// TODO Auto-generated method stub
		log.debug(hql);
		try {
			Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
			return queryObject.uniqueResult();
		} catch (RuntimeException e) {
			// TODO: handle exception
			log.error("find by HQL ", e);
			throw e;
		}
	
		
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		String hql= "delete "+entityClass;
		try{
		int re=hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
		}catch(RuntimeException exception){
			log.error("find by HQL ", exception);
			throw exception;
		}
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#saveForCopy(java.lang.Object)
	 */
	@Override
	public void saveForCopy(T instance) {
		// TODO Auto-generated method stub
				log.debug("saving" + instance + "instance");
				try {
					hibernateTemplate.save(instance);
					hibernateTemplate.flush();
					hibernateTemplate.clear();
					log.debug("ok");
				} catch (RuntimeException exception) {
					log.error(exception);
					throw exception;
				}
	}

	/* (non-Javadoc)
	 * @see com.dataCapture.dao.BaseDao#findbyHql(java.lang.String)
	 */

	

}
