package com.dataCapture.bean;

import java.util.Date;

import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月14日
 *
 * @TIME  上午11:27:25
 */
public class ForumBean {

	private String forumUrl;
	
	private String commonUrl;
	
	private String replyUrl;
	
	private String UUID;
	
	private String commonCount;
	
	private String replyCount;
	public Integer Id;
	
	private Integer CommonNum;

	


	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted=false;

	  /// <summary>
    /// 所属网站(1-Team,2-Elevate,3-Champion)
    /// </summary>
    private Integer WebsiteName =WebSiteConfig.WEB_SITE;
    /// <summary>
    /// 帖子标题
    /// </summary>
    private String Title ;
    /// <summary>
    /// 特色图片地址
    /// </summary>
    private String FeaturedImageUrl ;
    /// <summary>
    /// 帖子正文
    /// </summary>
    private String Body ;
    /// <summary>
    /// 图片地址
    /// </summary>
    private String ImageUrl ;
    /// <summary>
    /// 文档地址
    /// </summary>
    private String DocumentUrl ;
    /// <summary>
    /// 帖子标签
    /// </summary>
    private String Tag ;
    /// <summary>
    /// 帖子状态(0-草稿,1-发布,2-结束，3-测试)
    /// </summary>
    private Integer Status =1;
    /// <summary>
    /// 所属活动
    /// </summary>
    private String ParentId =WebSiteConfig.Activity_UUID;
    /// <summary>
    /// 喜爱人数
    /// </summary>
    private Integer LoveNum =0;
    /// <summary>
    /// 浏览次数
    /// </summary>
    private Integer ViewNum ;
    /// <summary>
    /// 创建人
    /// </summary>
    private String CreateUserId ;
    /// <summary>
    /// 修改时间
    /// </summary>
    private Date ModifyDate ;
    /// <summary>
    /// 是否推荐
    /// </summary>
    private Boolean Feature =false;
    /// <summary>
    /// 是否锁定
    /// </summary>
    private Boolean isLock =false;
	/**
	 * @return the forumUrl
	 */
	public String getForumUrl() {
		return forumUrl;
	}
	/**
	 * @param forumUrl the forumUrl to set
	 */
	public void setForumUrl(String forumUrl) {
		this.forumUrl = forumUrl;
	}
	/**
	 * @return the commonUrl
	 */
	public String getCommonUrl() {
		return commonUrl;
	}
	/**
	 * @param commonUrl the commonUrl to set
	 */
	public void setCommonUrl(String commonUrl) {
		this.commonUrl = commonUrl;
	}
	/**
	 * @return the replyUrl
	 */
	public String getReplyUrl() {
		return replyUrl;
	}
	/**
	 * @param replyUrl the replyUrl to set
	 */
	public void setReplyUrl(String replyUrl) {
		this.replyUrl = replyUrl;
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
	 * @return the commonCount
	 */
	public String getCommonCount() {
		return commonCount;
	}
	/**
	 * @param commonCount the commonCount to set
	 */
	public void setCommonCount(String commonCount) {
		this.commonCount = commonCount;
	}
	/**
	 * @return the replyCount
	 */
	public String getReplyCount() {
		return replyCount;
	}
	/**
	 * @param replyCount the replyCount to set
	 */
	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
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
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}
	/**
	 * @param title the title to set
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
	 * @param featuredImageUrl the featuredImageUrl to set
	 */
	public void setFeaturedImageUrl(String featuredImageUrl) {
		FeaturedImageUrl = featuredImageUrl;
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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return ImageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
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
	 * @param documentUrl the documentUrl to set
	 */
	public void setDocumentUrl(String documentUrl) {
		DocumentUrl = documentUrl;
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
	 * @return the status
	 */
	public Integer getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		Status = status;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return ParentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		ParentId = parentId;
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
	/**
	 * @return the viewNum
	 */
	public Integer getViewNum() {
		return ViewNum;
	}
	/**
	 * @param viewNum the viewNum to set
	 */
	public void setViewNum(Integer viewNum) {
		ViewNum = viewNum;
	}
	/**
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return CreateUserId;
	}
	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		CreateUserId = createUserId;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return ModifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		ModifyDate = modifyDate;
	}
	/**
	 * @return the feature
	 */
	public Boolean getFeature() {
		return Feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(Boolean feature) {
		Feature = feature;
	}
	/**
	 * @return the isLock
	 */
	public Boolean getIsLock() {
		return isLock;
	}
	/**
	 * @param isLock the isLock to set
	 */
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "ForumBean [forumUrl=" + forumUrl + ", commonUrl=" + commonUrl + ", replyUrl=" + replyUrl + ", UUID="
				+ UUID + ", commonCount=" + commonCount + ", replyCount=" + replyCount + ", CreateDateTime="
				+ CreateDateTime + ", IsDeleted=" + IsDeleted + ", WebsiteName=" + WebsiteName + ", Title=" + Title
				+ ", FeaturedImageUrl=" + FeaturedImageUrl + ", Body=" + Body + ", ImageUrl=" + ImageUrl
				+ ", DocumentUrl=" + DocumentUrl + ", Tag=" + Tag + ", Status=" + Status + ", ParentId=" + ParentId
				+ ", LoveNum=" + LoveNum + ", ViewNum=" + ViewNum + ", CreateUserId=" + CreateUserId + ", ModifyDate="
				+ ModifyDate + ", Feature=" + Feature + ", isLock=" + isLock + "]";
	}
	/**
	 * @return the id
	 */
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
	 * @return the commonNum
	 */
	public Integer getCommonNum() {
		return CommonNum;
	}
	/**
	 * @param commonNum the commonNum to set
	 */
	public void setCommonNum(Integer commonNum) {
		CommonNum = commonNum;
	}

    
    
	
	
}
