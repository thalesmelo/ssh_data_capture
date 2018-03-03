package com.dataCapture.reflectTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月16日
 *
 * @TIME  下午5:50:35
 */
public class CopyObject {

	//通过反射进行model与pojo间的传值
	public static <T> Object copy(Object object,T t) {
		
		Class<?> classType=object.getClass();
		
		@SuppressWarnings("unchecked")
		Class<T> clazz=(Class<T>) t.getClass();
		//获取类中的所有成员变量
		Field[] fields=clazz.getDeclaredFields(); 
		
		for (Field field : fields) {
			//获取属性名
			String fieldName=field.getName();
			
			//获取get.set
			String startWord=fieldName.substring(0, 1).toUpperCase();
			String getMethodName="get"+startWord+fieldName.substring(1);
			String setMethodName="set"+startWord+fieldName.substring(1);
			
			//获取方法对象
			Method getMethod = null;
			Method setMethod = null;
			try {
				getMethod = classType.getMethod(getMethodName, new Class[]{});
				setMethod=clazz.getMethod(setMethodName, new Class[]{field.getType()});
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			try {
				//获取值
				Object value = getMethod.invoke(object, new Object[]{});
				//设置值
				setMethod.invoke(t, new Object[]{value});
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return t;
	}
}
