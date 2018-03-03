package com.dataCapture.pojo;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月8日
 *
 * @TIME 下午4:39:51
 */
@Entity
public class Common{

	private Integer Id;
	private String UserName;
	private Date date;
	// Type 0:activities;1:news;2:training;4:photos;
	private Integer Type;
	private String Parent;
	private String Comment;
	private String ImageUrl;
	private String ActivityId;
	// 锁定 0:false;1:true
	private Integer Lock=0;
	private Integer Feature=0;
	private String CreateUserUUID;
	private Date CreateDateTime;
	private Boolean IsDeleted =false;
	private String UUID;
	private String ReplyId;
	private Integer WebsiteName=WebSiteConfig.WEB_SITE;
	private Integer LoveNum;

	/**
	 * @return the replyId
	 */
	public String getReplyId() {
		return ReplyId;
	}

	/**
	 * @param replyId
	 *            the replyId to set
	 */
	public void setReplyId(String replyId) {
		ReplyId = replyId;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return IsDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		IsDeleted = isDeleted;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return CreateDateTime;
	}

	/**
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return Type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		Type = type;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return Parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(String parent) {
		Parent = parent;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return Comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		Comment = comment;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return ImageUrl;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	/**
	 * @return the activityId
	 */
	public String getActivityId() {
		return ActivityId;
	}

	/**
	 * @param activityId
	 *            the activityId to set
	 */
	public void setActivityId(String activityId) {
		ActivityId = activityId;
	}

	/**
	 * @return the lock
	 */
	public Integer getLock() {
		return Lock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Common [Id=" + Id + ", UserName=" + UserName + ", date=" + date + ", Type=" + Type + ", Parent="
				+ Parent + ", Comment=" + Comment + ", ImageUrl=" + ImageUrl + ", ActivityId=" + ActivityId + ", Lock="
				+ Lock + ", Feature=" + Feature + ", CreateUserUUID=" + CreateUserUUID + "]";
	}

	/**
	 * @param lock
	 *            the lock to set
	 */
	public void setLock(Integer lock) {
		Lock = lock;
	}

	/**
	 * @return the feature
	 */
	public Integer getFeature() {
		return Feature;
	}

	/**
	 * @param feature
	 *            the feature to set
	 */
	public void setFeature(Integer feature) {
		Feature = feature;
	}

	/**
	 * @return the createUserUUID
	 */
	public String getCreateUserUUID() {
		return CreateUserUUID;
	}

	/**
	 * @param createUserUUID
	 *            the createUserUUID to set
	 */
	public void setCreateUserUUID(String createUserUUID) {
		CreateUserUUID = createUserUUID;
	}

	/**
	 * @return the websiteName
	 */
	public Integer getWebsiteName() {
		return WebsiteName;
	}

	/**
	 * @param websiteName the websiteName to set
	 */
	public void setWebsiteName(Integer websiteName) {
		WebsiteName = websiteName;
	}

	/**
	 * @return the loveNum
	 */
	public Integer getLoveNum() {
		return LoveNum;
	}

	/**
	 * @param loveNum the loveNum to set
	 */
	public void setLoveNum(Integer loveNum) {
		LoveNum = loveNum;
	}
	
	

}
