package com.dataCapture.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月10日
 *
 * @TIME  上午10:12:19
 */
@Entity
public class Photos_copy {
	private Integer Id;

	/// 唯一

	private String UUID;

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted=false;

    /// <summary>
    /// 标题
    /// </summary>
    private String Title ;

    /// <summary>
    ///内容
    /// </summary>
    private String Description ;

    /// <summary>
    ///标签
    /// </summary>
   // private String Tag ;

    /// <summary>
    /// 访问级别（1-所有人可以访问，2-只允许部分用户组可以访问）
    /// </summary>
    private Integer VisibleLevel ;

    /// <summary>
    /// 访问级别（可以访问用户组名称）
    /// </summary>
    private String VisibleLevelName ;

    /// <summary>
    /// 贡献级别（可以贡献用户组名称）
    /// </summary>
    private String Contribute ;

    /// <summary>
    /// 创建用户ID
    /// </summary>
    private String Userid ;

    /// <summary>
    /// 0：不推荐到首页；1：推荐到首页；
    /// </summary>
    private Integer Type ;

    /// <summary>
    /// 1：Featured 1；2：Featured 2；3:Featured 3
    /// </summary>
    private Integer Position ;

    private Integer WebsiteName ;

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
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the visibleLevel
	 */
	public Integer getVisibleLevel() {
		return VisibleLevel;
	}

	/**
	 * @param visibleLevel the visibleLevel to set
	 */
	public void setVisibleLevel(Integer visibleLevel) {
		VisibleLevel = visibleLevel;
	}

	/**
	 * @return the visibleLevelName
	 */
	public String getVisibleLevelName() {
		return VisibleLevelName;
	}

	/**
	 * @param visibleLevelName the visibleLevelName to set
	 */
	public void setVisibleLevelName(String visibleLevelName) {
		VisibleLevelName = visibleLevelName;
	}

	/**
	 * @return the contribute
	 */
	public String getContribute() {
		return Contribute;
	}

	/**
	 * @param contribute the contribute to set
	 */
	public void setContribute(String contribute) {
		Contribute = contribute;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return Userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		Userid = userid;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return Type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		Type = type;
	}

	/**
	 * @return the position
	 */
	public Integer getPosition() {
		return Position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Integer position) {
		Position = position;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Photos [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted=" + IsDeleted
				+ ", Title=" + Title + ", Description=" + Description + ", VisibleLevel=" + VisibleLevel
				+ ", VisibleLevelName=" + VisibleLevelName + ", Contribute=" + Contribute + ", Userid=" + Userid
				+ ", Type=" + Type + ", Position=" + Position + ", WebsiteName=" + WebsiteName + "]";
	}
    
    
    
	
}
