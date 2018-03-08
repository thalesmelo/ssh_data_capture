package com.dataCapture.bean;

import java.util.Date;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月19日
 *
 * @TIME 下午4:43:02
 */
public class PhotoBean {

	private String photoUrl;

	private String commonUrl;

	private String replyUrl;

	private Integer Id;
	
	private String iconUrl;

	/// 唯一

	private String UUID;

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted = false;

	/// <summary>
	/// 主相册ID
	/// </summary>
	private String Ids;

	/// <summary>
	/// 相册标题
	/// </summary>
	private String Title;

	/// <summary>
	/// url
	/// </summary>
	private String Img;

	/// <summary>
	/// 相册内容
	/// </summary>
	private String Description;

	/// <summary>
	/// 标记
	/// </summary>
	private String Tags;

	/// <summary>
	/// 0:不推荐为首图；1：推荐首图
	/// </summary>
	private Integer Type = 0;

	/// <summary>
	/// 创建用户ID
	/// </summary>
	private String Userid;
	/**
	 * @return the id
	 */
	private Integer LoveNum = 0;
	private Integer ViewNum = 0;
	private Integer CommonNum = 0;

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl
	 *            the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the commonUrl
	 */
	public String getCommonUrl() {
		return commonUrl;
	}

	/**
	 * @param commonUrl
	 *            the commonUrl to set
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
	 * @param replyUrl
	 *            the replyUrl to set
	 */
	public void setReplyUrl(String replyUrl) {
		this.replyUrl = replyUrl;
	}

	/**
	 * @return the id
	 */
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
	 * @return the ids
	 */
	public String getIds() {
		return Ids;
	}

	/**
	 * @param ids
	 *            the ids to set
	 */
	public void setIds(String ids) {
		Ids = ids;
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
	 * @return the img
	 */
	public String getImg() {
		return Img;
	}

	/**
	 * @param img
	 *            the img to set
	 */
	public void setImg(String img) {
		Img = img;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return Tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(String tags) {
		Tags = tags;
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
	 * @return the userid
	 */
	public String getUserid() {
		return Userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		Userid = userid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhotoBean [photoUrl=" + photoUrl + ", commonUrl=" + commonUrl + ", replyUrl=" + replyUrl + ", Id=" + Id
				+ ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted=" + IsDeleted + ", Ids=" + Ids
				+ ", Title=" + Title + ", Img=" + Img + ", Description=" + Description + ", Tags=" + Tags + ", Type="
				+ Type + ", Userid=" + Userid + "]";
	}

	/**
	 * @return the loveNum
	 */
	public Integer getLoveNum() {
		return LoveNum;
	}

	/**
	 * @param loveNum
	 *            the loveNum to set
	 */
	public void setLoveNum(Integer loveNum) {
		LoveNum = loveNum;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

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

	
}
