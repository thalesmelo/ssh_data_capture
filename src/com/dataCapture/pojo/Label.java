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
 * @TIME 下午2:01:50
 */
@Entity
public class Label {
	private Integer labelId;

	private String labelName;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getLabelId() {
		return labelId;
	}

	/**
	 * @return the labelName
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * @param labelId
	 *            the labelId to set
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	/**
	 * @param labelName
	 *            the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Label [新闻小标签=" + labelName + "]";
	}

}
