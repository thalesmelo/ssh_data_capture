package com.dataCapture.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhuCan
 *
 * @DATE 2018年2月24日
 *
 * @TIME 上午10:47:47
 */
@Entity
public class ActivityModel_copy {

	private Integer Id;

	/// 唯一

	private String UUID = java.util.UUID.randomUUID().toString();

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted = false;

	private String ActivityUUID;

	private String Body;

	private String Image;

	private String ImageId;

	private String Checked;

	private String CheckedId;

	private String Tag;

	private String DataList;

	private String UserID;

	private String Slider;

	private String sliderid;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return CreateDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return IsDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		IsDeleted = isDeleted;
	}

	/**
	 * @return the activityUUID
	 */
	public String getActivityUUID() {
		return ActivityUUID;
	}

	/**
	 * @param activityUUID the activityUUID to set
	 */
	public void setActivityUUID(String activityUUID) {
		ActivityUUID = activityUUID;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return Body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		Body = body;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return Image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		Image = image;
	}

	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return ImageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		ImageId = imageId;
	}

	/**
	 * @return the checked
	 */
	public String getChecked() {
		return Checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(String checked) {
		Checked = checked;
	}

	/**
	 * @return the checkedId
	 */
	public String getCheckedId() {
		return CheckedId;
	}

	/**
	 * @param checkedId the checkedId to set
	 */
	public void setCheckedId(String checkedId) {
		CheckedId = checkedId;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return Tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		Tag = tag;
	}

	/**
	 * @return the dataList
	 */
	public String getDataList() {
		return DataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(String dataList) {
		DataList = dataList;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		UserID = userID;
	}

	/**
	 * @return the slider
	 */
	public String getSlider() {
		return Slider;
	}

	/**
	 * @param slider the slider to set
	 */
	public void setSlider(String slider) {
		Slider = slider;
	}

	/**
	 * @return the sliderid
	 */
	public String getSliderid() {
		return sliderid;
	}

	/**
	 * @param sliderid the sliderid to set
	 */
	public void setSliderid(String sliderid) {
		this.sliderid = sliderid;
	}
	
	
}
