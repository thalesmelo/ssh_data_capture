package com.dataCapture.service;

import java.util.List;

import com.dataCapture.pojo.Tags;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月16日
 *
 * @TIME 上午11:47:14
 */
public interface TagService {

	void save(Tags tag);

	void deleteAll();

	List<Tags> queryAll();
}
