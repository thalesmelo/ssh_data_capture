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
 * @TIME 上午10:31:23
 */
@Entity
public class News_copy {

	private Integer Id;
	private String Title;
	private String FeaturedImageUrl;
	/// 新闻描述
	private String Teaser;
	private String ImageUrl;
	private String DocumentUrl;
	// private String Tag;
	/// 新闻状态(0-草稿,1-发布,2-结束，3-测试)
	private Integer Status = 1;
	private Integer LoveNum = 0;
	private Integer ViewNum = 0;
	private Date CreateDateTime;
	private Boolean IsDeleted = false;
	private String CreateUserId;
	/// 是否计划发布
	private Boolean Scheduled = false;
	private Date ScheduledDate;
	private String VisibleLevelName;
	private Date ModifyDateTime;
	/// 分类（1-News 2- Training）
	private Integer BlogId;
	/// 访问级别（1-所有人可以访问，2-只允许部分用户组可以访问）
	private Integer VisibleLevel = 1;
	private String UUID;
	/// 是否推荐
	private Boolean Feature = false;
	private Integer OrderId;
	private Boolean isLock = false;
	private Integer WebsiteName = WebSiteConfig.WEB_SITE;
	private String Body;

	private Integer CommonNum;

	/**
	 * @return the commonNum
	 */
	public Integer getCommonNum() {
		return CommonNum;
	}

	/**
	 * @param commonNum
	 *            the commonNum to set
	 */
	public void setCommonNum(Integer commonNum) {
		CommonNum = commonNum;
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
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the featuredImageUrl
	 */
	public String getFeaturedImageUrl() {
		return FeaturedImageUrl;
	}

	/**
	 * @param featuredImageUrl
	 *            the featuredImageUrl to set
	 */
	public void setFeaturedImageUrl(String featuredImageUrl) {
		FeaturedImageUrl = featuredImageUrl;
	}

	/**
	 * @return the teaser
	 */
	public String getTeaser() {
		return Teaser;
	}

	/**
	 * @param teaser
	 *            the teaser to set
	 */
	public void setTeaser(String teaser) {
		Teaser = teaser;
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
	 * @return the documentUrl
	 */
	public String getDocumentUrl() {
		return DocumentUrl;
	}

	/**
	 * @param documentUrl
	 *            the documentUrl to set
	 */
	public void setDocumentUrl(String documentUrl) {
		DocumentUrl = documentUrl;
	}
	/**
	 * @return the tag
	 */
	/*
	 * public String getTag() { return Tag; }
	 *//**
		 * @param tag
		 *            the tag to set
		 *//*
		 * public void setTag(String tag) { Tag = tag; }
		 */

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		Status = status;
	}

	/**
	 * @return the lovaNum
	 */
	public Integer getLoveNum() {
		return LoveNum;
	}

	/**
	 * @param lovaNum
	 *            the lovaNum to set
	 */
	public void setLoveNum(Integer lovaNum) {
		LoveNum = lovaNum;
	}

	/**
	 * @return the viewNum
	 */
	public Integer getViewNum() {
		return ViewNum;
	}

	/**
	 * @param viewNum
	 *            the viewNum to set
	 */
	public void setViewNum(Integer viewNum) {
		ViewNum = viewNum;
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
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return CreateUserId;
	}

	/**
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		CreateUserId = createUserId;
	}

	/**
	 * @return the scheduled
	 */
	public Boolean getScheduled() {
		return Scheduled;
	}

	/**
	 * @param scheduled
	 *            the scheduled to set
	 */
	public void setScheduled(Boolean scheduled) {
		Scheduled = scheduled;
	}

	/**
	 * @return the scheduledDate
	 */
	public Date getScheduledDate() {
		return ScheduledDate;
	}

	/**
	 * @param scheduledDate
	 *            the scheduledDate to set
	 */
	public void setScheduledDate(Date scheduledDate) {
		ScheduledDate = scheduledDate;
	}

	/**
	 * @return the visibleLevelName
	 */
	public String getVisibleLevelName() {
		return VisibleLevelName;
	}

	/**
	 * @param visibleLevelName
	 *            the visibleLevelName to set
	 */
	public void setVisibleLevelName(String visibleLevelName) {
		VisibleLevelName = visibleLevelName;
	}

	/**
	 * @return the modifyDateTime
	 */
	public Date getModifyDateTime() {
		return ModifyDateTime;
	}

	/**
	 * @param modifyDateTime
	 *            the modifyDateTime to set
	 */
	public void setModifyDateTime(Date modifyDateTime) {
		ModifyDateTime = modifyDateTime;
	}

	/**
	 * @return the blogId
	 */
	public Integer getBlogId() {
		return BlogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(Integer blogId) {
		BlogId = blogId;
	}

	/**
	 * @return the visibleLevel
	 */
	public Integer getVisibleLevel() {
		return VisibleLevel;
	}

	/**
	 * @param visibleLevel
	 *            the visibleLevel to set
	 */
	public void setVisibleLevel(Integer visibleLevel) {
		VisibleLevel = visibleLevel;
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
	 * @return the feature
	 */
	public Boolean getFeature() {
		return Feature;
	}

	/**
	 * @param feature
	 *            the feature to set
	 */
	public void setFeature(Boolean feature) {
		Feature = feature;
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return OrderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	/**
	 * @return the isLock
	 */
	public Boolean getIsLock() {
		return isLock;
	}

	/**
	 * @param isLock
	 *            the isLock to set
	 */
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}

	/**
	 * @return the websiteName
	 */
	public Integer getWebsiteName() {
		return WebsiteName;
	}

	/**
	 * @param websiteName
	 *            the websiteName to set
	 */
	public void setWebsiteName(Integer websiteName) {
		WebsiteName = websiteName;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return Body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		Body = body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [Id=" + Id + ", Title=" + Title + ", FeaturedImageUrl=" + FeaturedImageUrl + ", Teaser=" + Teaser
				+ ", ImageUrl=" + ImageUrl + ", DocumentUrl=" + DocumentUrl + ", Status=" + Status + ", LovaNum="
				+ LoveNum + ", ViewNum=" + ViewNum + ", CreateDateTime=" + CreateDateTime + ", IsDeleted=" + IsDeleted
				+ ", CreateUserId=" + CreateUserId + ", Scheduled=" + Scheduled + ", ScheduledDate=" + ScheduledDate
				+ ", VisibleLevelName=" + VisibleLevelName + ", ModifyDateTime=" + ModifyDateTime + ", BlogId=" + BlogId
				+ ", VisibleLevel=" + VisibleLevel + ", UUID=" + UUID + ", Feature=" + Feature + ", OrderId=" + OrderId
				+ ", isLock=" + isLock + ", WebsiteName=" + WebsiteName + ", Body=" + Body + "]";
	}

}
