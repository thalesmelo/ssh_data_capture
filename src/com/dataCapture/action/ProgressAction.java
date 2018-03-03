package com.dataCapture.action;

import com.dataCapture.util.Progress;
import com.dataCapture.util.WebSiteConfig;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月1日
 *
 * @TIME  上午9:38:46
 */
@SuppressWarnings("serial")
public class ProgressAction extends ActionSupport{
	
	private Integer index;
	private Integer common;
	private Integer tag;
	private Integer img;
	private Integer photo;
	private Boolean error;
	private Integer total;

	public String progress(){
		index=Progress.proIndex;
		common=Progress.commonIndex;
		tag=Progress.tagIndex;
		photo=Progress.photoIndex;
		img=Progress.imgIndex;
		error=Progress.error;
		total=WebSiteConfig.Total_index;
		
		return SUCCESS;
		
	}

	
	
	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}



	/**
	 * @param error the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}



	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the common
	 */
	public Integer getCommon() {
		return common;
	}

	/**
	 * @param common the common to set
	 */
	public void setCommon(Integer common) {
		this.common = common;
	}

	/**
	 * @return the tag
	 */
	public Integer getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(Integer tag) {
		this.tag = tag;
	}

	/**
	 * @return the img
	 */
	public Integer getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(Integer img) {
		this.img = img;
	}

	/**
	 * @return the photo
	 */
	public Integer getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Integer photo) {
		this.photo = photo;
	}



	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}



	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
