package com.dataCapture.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhuCan
 *
 * @DATE 2017年9月30日
 *
 * @TIME 下午2:22:37
 */
@Entity
public class User_tag {

	private Integer tagId;

	/**
	 * @return the tagId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getTagId() {
		return tagId;
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	private String userTag;

	/**
	 * @return the userTag
	 */
	public String getUserTag() {
		return userTag;
	}

	/**
	 * @param userTag
	 *            the userTag to set
	 */
	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User_tag [人物标签=" + userTag + "]";
	}

}
