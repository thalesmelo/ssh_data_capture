package com.dataCapture.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月6日
 *
 * @TIME  下午4:34:05
 */
@Entity
public class ActivityFeed {
	
	private Integer Id;

	/// 唯一

	private String UUID=java.util.UUID.randomUUID().toString();

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted=false;
	  /// <summary>
    /// 活动从属类型（1-Common、2-Follow）
    /// </summary>
   
	private Integer SubjectType ;
    /// <summary>
    /// 活动从属发起用户Id
    /// </summary>
   
    private String SubjectId ;
    /// <summary>
    /// 活动从属发起用户名称
    /// </summary>
   
    private String SubjectUserName ;
    /// <summary>
    /// 活动从属发起用户头像
    /// </summary>
   
    private String SubjectUserImgUrl ;

    /// <summary>
    /// 活动名称
    /// </summary>
   
    private String ObjectName ;
    /// <summary>
    /// 活动Id
    /// </summary>
   
    private String ObjectId ;

    ///<summary
    ///该活动显示的页面路径
    ///</sumary>
    private String ObjectUrl ;
    /// <summary>
    /// 所属网站(1-Team,2-Elevate,3-Champion)
    /// </summary>
    private int WebsiteName ;
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
	 * @return the subjectType
	 */
	public Integer getSubjectType() {
		return SubjectType;
	}
	/**
	 * @param subjectType the subjectType to set
	 */
	public void setSubjectType(Integer subjectType) {
		SubjectType = subjectType;
	}
	/**
	 * @return the subjectId
	 */
	public String getSubjectId() {
		return SubjectId;
	}
	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	/**
	 * @return the subjectUserName
	 */
	public String getSubjectUserName() {
		return SubjectUserName;
	}
	/**
	 * @param subjectUserName the subjectUserName to set
	 */
	public void setSubjectUserName(String subjectUserName) {
		SubjectUserName = subjectUserName;
	}
	/**
	 * @return the subjectUserImgUrl
	 */
	public String getSubjectUserImgUrl() {
		return SubjectUserImgUrl;
	}
	/**
	 * @param subjectUserImgUrl the subjectUserImgUrl to set
	 */
	public void setSubjectUserImgUrl(String subjectUserImgUrl) {
		SubjectUserImgUrl = subjectUserImgUrl;
	}
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return ObjectName;
	}
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		ObjectName = objectName;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return ObjectId;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}
	/**
	 * @return the objectUrl
	 */
	public String getObjectUrl() {
		return ObjectUrl;
	}
	/**
	 * @param objectUrl the objectUrl to set
	 */
	public void setObjectUrl(String objectUrl) {
		ObjectUrl = objectUrl;
	}
	/**
	 * @return the websiteName
	 */
	public int getWebsiteName() {
		return WebsiteName;
	}
	/**
	 * @param websiteName the websiteName to set
	 */
	public void setWebsiteName(int websiteName) {
		WebsiteName = websiteName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityFeed [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted="
				+ IsDeleted + ", SubjectType=" + SubjectType + ", SubjectId=" + SubjectId + ", SubjectUserName="
				+ SubjectUserName + ", SubjectUserImgUrl=" + SubjectUserImgUrl + ", ObjectName=" + ObjectName
				+ ", ObjectId=" + ObjectId + ", ObjectUrl=" + ObjectUrl + ", WebsiteName=" + WebsiteName + "]";
	}
    
    
}
