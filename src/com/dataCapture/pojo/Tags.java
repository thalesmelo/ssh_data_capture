package com.dataCapture.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月16日
 *
 * @TIME  上午10:54:14
 */
@Entity
public class Tags {
	private Integer Id;

	/// 唯一

	private String UUID=java.util.UUID.randomUUID().toString();

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted=false;
	   /// <summary>
    /// 标签名称
    /// </summary>
    private String Name ;
    /// <summary>
    /// 关联模块Id
    /// </summary>
    private String ModuleId ;
    /// <summary>
    /// 标签分类枚举类（TagType）
    /// </summary>
    /*
     *  Album = 1,
        Photo = 2,
        User = 3,
        Activity = 4,
        New = 5,
        Traning = 6,
        Disscussion = 7,
        //Forums = 8,帖子
        Comment=9
     * 
     * */
    private Integer TagGype ;
    /// <summary>
    /// 所属网站(1-Team,2-Elevate,3-Champion)
    /// </summary>
    private Integer WebsiteName =WebSiteConfig.WEB_SITE;
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
	@GeneratedValue(generator="UUID")
	@GenericGenerator(strategy="uuid",name="UUID")
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
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the moduleId
	 */
	public String getModuleId() {
		return ModuleId;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(String moduleId) {
		ModuleId = moduleId;
	}
	/**
	 * @return the tagGype
	 */
	public Integer getTagGype() {
		return TagGype;
	}
	/**
	 * @param tagGype the tagGype to set
	 */
	public void setTagGype(Integer tagGype) {
		TagGype = tagGype;
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
		return "Tag [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted=" + IsDeleted
				+ ", Name=" + Name + ", ModuleId=" + ModuleId + ", TagGype=" + TagGype + ", WebsiteName=" + WebsiteName
				+ "]";
	}
    
    
}
