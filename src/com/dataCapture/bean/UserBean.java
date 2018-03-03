package com.dataCapture.bean;

import java.util.Date;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月19日
 *
 * @TIME  下午5:57:56
 */
public class UserBean {
	private Integer Id;

	/// 唯一

	private String UUID;

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted;

	 /// <summary>
    /// 登录账号
    /// </summary>
    private String LoginName ;

    /// <summary>
    /// 真实姓名
    /// </summary>
    private String RealName ;

    /// <summary>
    /// 邮箱
    /// </summary>
    private String Email ;

    /// <summary>
    /// 登录密码
    /// </summary>
    private String Password ;

    /// <summary>
    /// 状态
    /// </summary>
    private byte Status ;

    /// <summary>
    /// 所属用户组
    /// </summary>
    private String UserGroupId ;
    /// <summary>
    /// 所属角色
    /// </summary>
    private Integer UserRoleId ;

    /// <summary>
    /// 上次登录时间
    /// </summary>
    private Date LastLogIntegerime ;
    /// <summary>
    /// 菜单Id
    /// </summary>
    private String MenusId ;
    /// <summary>
    /// 用户被删除的原因
    /// </summary>
    private String DeleteReason ;

    /// <summary>
    /// 用户被禁用的原因
    /// </summary>
    private String SuspendReason ;
    /// <summary>
    /// 用户的自定义标签
    /// </summary>
    private String Tags ;

    /// <summary>
    /// 重置密码状态
    /// </summary>
    private Boolean ResetStatus ;

    /// <summary>
    /// 是否完善用户资料
    /// </summary>
    private Boolean ProfileComplete ;

   
    /// <summary>
    /// 名
    /// </summary>
    private String FirstName ;

    /// <summary>
    /// 姓
    /// </summary>
    private String LastName ;

    /// <summary>
    /// 性别
    /// </summary>
    private Integer Gender ;

    /// <summary>
    /// 公司邮箱
    /// </summary>
    private String CorporateEmail ;

    /// <summary>
    /// 个人电话号码
    /// </summary>
    private String PrimaryPhoneNumber ;

    /// <summary>
    /// 主要的手机
    /// </summary>
    private String PrimarySmartphone ;

    /// <summary>
    /// 最喜欢的HTC手机
    /// </summary>
    private String FavoriteHTCSmartphone ;

    /// <summary>
    /// 邮寄地址
    /// </summary>
    private String MailingAddress ;

    /// <summary>
    /// 所在城市
    /// </summary>
    private String City ;

    /// <summary>
    /// 所在州
    /// </summary>
    private String State ;

    /// <summary>
    /// 邮编
    /// </summary>
    private String ZipCode ;

    /// <summary>
    /// 商店链接
    /// </summary>
    private String StoreAddress ;
    
    /// <summary>
    /// 商店名称
    /// </summary>
    private String StoreName ;

    /// <summary>
    /// 商店所在城市邮编
    /// </summary>
    private String SroreCityZipCode ;

    /// <summary>
    /// 商店载体
    /// </summary>
    private Integer StoreCarrier ;
    
    /// <summary>
    /// LinkedIn地址
    /// </summary>
    private String LinkedIn ;

    private String Twitter ;

    private String FaceBook ;

    /// <summary>
    /// 个人网站地址
    /// </summary>
    private String Website ;

    /// <summary>
    /// 个人介绍
    /// </summary>
    private String Biography ;

    /// <summary>
    /// 所属网站(1-Team,2-Elevate,3-Champion)
    /// </summary>
    private Integer WebsiteName ;
    /// <summary>
    /// 用户头像地址
    /// </summary>
    private String HeaderImgUrl ;
    /// <summary>
    /// 用户等级
    /// </summary>
    private String RankUUID ;
    /// <summary>
    /// 用户等级获取时间
    /// </summary>
    private Date RankUpDate ;
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
	 * @return the loginName
	 */
	public String getLoginName() {
		return LoginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return RealName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		RealName = realName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * @return the status
	 */
	public byte getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(byte status) {
		Status = status;
	}
	/**
	 * @return the userGroupId
	 */
	public String getUserGroupId() {
		return UserGroupId;
	}
	/**
	 * @param userGroupId the userGroupId to set
	 */
	public void setUserGroupId(String userGroupId) {
		UserGroupId = userGroupId;
	}
	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return UserRoleId;
	}
	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		UserRoleId = userRoleId;
	}
	/**
	 * @return the lastLogIntegerime
	 */
	public Date getLastLogIntegerime() {
		return LastLogIntegerime;
	}
	/**
	 * @param lastLogIntegerime the lastLogIntegerime to set
	 */
	public void setLastLogIntegerime(Date lastLogIntegerime) {
		LastLogIntegerime = lastLogIntegerime;
	}
	/**
	 * @return the menusId
	 */
	public String getMenusId() {
		return MenusId;
	}
	/**
	 * @param menusId the menusId to set
	 */
	public void setMenusId(String menusId) {
		MenusId = menusId;
	}
	/**
	 * @return the deleteReason
	 */
	public String getDeleteReason() {
		return DeleteReason;
	}
	/**
	 * @param deleteReason the deleteReason to set
	 */
	public void setDeleteReason(String deleteReason) {
		DeleteReason = deleteReason;
	}
	/**
	 * @return the suspendReason
	 */
	public String getSuspendReason() {
		return SuspendReason;
	}
	/**
	 * @param suspendReason the suspendReason to set
	 */
	public void setSuspendReason(String suspendReason) {
		SuspendReason = suspendReason;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return Tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		Tags = tags;
	}
	/**
	 * @return the resetStatus
	 */
	public Boolean getResetStatus() {
		return ResetStatus;
	}
	/**
	 * @param resetStatus the resetStatus to set
	 */
	public void setResetStatus(Boolean resetStatus) {
		ResetStatus = resetStatus;
	}
	/**
	 * @return the profileComplete
	 */
	public Boolean getProfileComplete() {
		return ProfileComplete;
	}
	/**
	 * @param profileComplete the profileComplete to set
	 */
	public void setProfileComplete(Boolean profileComplete) {
		ProfileComplete = profileComplete;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return Gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		Gender = gender;
	}
	/**
	 * @return the corporateEmail
	 */
	public String getCorporateEmail() {
		return CorporateEmail;
	}
	/**
	 * @param corporateEmail the corporateEmail to set
	 */
	public void setCorporateEmail(String corporateEmail) {
		CorporateEmail = corporateEmail;
	}
	/**
	 * @return the primaryPhoneNumber
	 */
	public String getPrimaryPhoneNumber() {
		return PrimaryPhoneNumber;
	}
	/**
	 * @param primaryPhoneNumber the primaryPhoneNumber to set
	 */
	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		PrimaryPhoneNumber = primaryPhoneNumber;
	}
	/**
	 * @return the primarySmartphone
	 */
	public String getPrimarySmartphone() {
		return PrimarySmartphone;
	}
	/**
	 * @param primarySmartphone the primarySmartphone to set
	 */
	public void setPrimarySmartphone(String primarySmartphone) {
		PrimarySmartphone = primarySmartphone;
	}
	/**
	 * @return the favoriteHTCSmartphone
	 */
	public String getFavoriteHTCSmartphone() {
		return FavoriteHTCSmartphone;
	}
	/**
	 * @param favoriteHTCSmartphone the favoriteHTCSmartphone to set
	 */
	public void setFavoriteHTCSmartphone(String favoriteHTCSmartphone) {
		FavoriteHTCSmartphone = favoriteHTCSmartphone;
	}
	/**
	 * @return the mailingAddress
	 */
	public String getMailingAddress() {
		return MailingAddress;
	}
	/**
	 * @param mailingAddress the mailingAddress to set
	 */
	public void setMailingAddress(String mailingAddress) {
		MailingAddress = mailingAddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return ZipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	/**
	 * @return the storeAddress
	 */
	public String getStoreAddress() {
		return StoreAddress;
	}
	/**
	 * @param storeAddress the storeAddress to set
	 */
	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}
	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return StoreName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	/**
	 * @return the sroreCityZipCode
	 */
	public String getSroreCityZipCode() {
		return SroreCityZipCode;
	}
	/**
	 * @param sroreCityZipCode the sroreCityZipCode to set
	 */
	public void setSroreCityZipCode(String sroreCityZipCode) {
		SroreCityZipCode = sroreCityZipCode;
	}
	/**
	 * @return the storeCarrier
	 */
	public Integer getStoreCarrier() {
		return StoreCarrier;
	}
	/**
	 * @param storeCarrier the storeCarrier to set
	 */
	public void setStoreCarrier(Integer storeCarrier) {
		StoreCarrier = storeCarrier;
	}
	/**
	 * @return the linkedIn
	 */
	public String getLinkedIn() {
		return LinkedIn;
	}
	/**
	 * @param linkedIn the linkedIn to set
	 */
	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}
	/**
	 * @return the twitter
	 */
	public String getTwitter() {
		return Twitter;
	}
	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter) {
		Twitter = twitter;
	}
	/**
	 * @return the faceBook
	 */
	public String getFaceBook() {
		return FaceBook;
	}
	/**
	 * @param faceBook the faceBook to set
	 */
	public void setFaceBook(String faceBook) {
		FaceBook = faceBook;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return Website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		Website = website;
	}
	/**
	 * @return the biography
	 */
	public String getBiography() {
		return Biography;
	}
	/**
	 * @param biography the biography to set
	 */
	public void setBiography(String biography) {
		Biography = biography;
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
	 * @return the headerImgUrl
	 */
	public String getHeaderImgUrl() {
		return HeaderImgUrl;
	}
	/**
	 * @param headerImgUrl the headerImgUrl to set
	 */
	public void setHeaderImgUrl(String headerImgUrl) {
		HeaderImgUrl = headerImgUrl;
	}
	/**
	 * @return the rankUUID
	 */
	public String getRankUUID() {
		return RankUUID;
	}
	/**
	 * @param rankUUID the rankUUID to set
	 */
	public void setRankUUID(String rankUUID) {
		RankUUID = rankUUID;
	}
	/**
	 * @return the rankUpDate
	 */
	public Date getRankUpDate() {
		return RankUpDate;
	}
	/**
	 * @param rankUpDate the rankUpDate to set
	 */
	public void setRankUpDate(Date rankUpDate) {
		RankUpDate = rankUpDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBean [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted="
				+ IsDeleted + ", LoginName=" + LoginName + ", RealName=" + RealName + ", Email=" + Email + ", Password="
				+ Password + ", Status=" + Status + ", UserGroupId=" + UserGroupId + ", UserRoleId=" + UserRoleId
				+ ", LastLogIntegerime=" + LastLogIntegerime + ", MenusId=" + MenusId + ", DeleteReason=" + DeleteReason
				+ ", SuspendReason=" + SuspendReason + ", Tags=" + Tags + ", ResetStatus=" + ResetStatus
				+ ", ProfileComplete=" + ProfileComplete + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Gender=" + Gender + ", CorporateEmail=" + CorporateEmail + ", PrimaryPhoneNumber="
				+ PrimaryPhoneNumber + ", PrimarySmartphone=" + PrimarySmartphone + ", FavoriteHTCSmartphone="
				+ FavoriteHTCSmartphone + ", MailingAddress=" + MailingAddress + ", City=" + City + ", State=" + State
				+ ", ZipCode=" + ZipCode + ", StoreAddress=" + StoreAddress + ", StoreName=" + StoreName
				+ ", SroreCityZipCode=" + SroreCityZipCode + ", StoreCarrier=" + StoreCarrier + ", LinkedIn=" + LinkedIn
				+ ", Twitter=" + Twitter + ", FaceBook=" + FaceBook + ", Website=" + Website + ", Biography="
				+ Biography + ", WebsiteName=" + WebsiteName + ", HeaderImgUrl=" + HeaderImgUrl + ", RankUUID="
				+ RankUUID + ", RankUpDate=" + RankUpDate + "]";
	}
    
	
    
}
