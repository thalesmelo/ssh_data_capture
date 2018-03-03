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
 * @TIME  上午10:19:55
 */
@Entity
public class PhotosImg {
	
	private Integer Id;

	/// 唯一

	private String UUID;

	/// 创建日期

	private Date CreateDateTime;

	/// 是否删除

	private Boolean IsDeleted=false;

    /// <summary>
    /// 主相册ID
    /// </summary>
    private String  Ids ;


    /// <summary>
    /// 相册标题
    /// </summary>
    private String Title ;

    /// <summary>
    /// url
    /// </summary>
    private String Img ;

    /// <summary>
    /// 相册内容
    /// </summary>
    private String Description ;

    /// <summary>
    /// 标记
    /// </summary>
  //  private String Tags ;

    /// <summary>
    ///0:不推荐为首图；1：推荐首图
    /// </summary>
    private Integer Type ;


    /// <summary>
    /// 创建用户ID
    /// </summary>
    private String Userid ;
	/**
	 * @return the id
	 */
    private Integer LoveNum=0;
	private Integer ViewNum=0;
	private Integer CommonNum;
	
	


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
	 * @return the ids
	 */
	public String getIds() {
		return Ids;
	}


	/**
	 * @param ids the ids to set
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
	 * @param title the title to set
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
	 * @param img the img to set
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhotosImg [Id=" + Id + ", UUID=" + UUID + ", CreateDateTime=" + CreateDateTime + ", IsDeleted="
				+ IsDeleted + ", Ids=" + Ids + ", Title=" + Title + ", Img=" + Img + ", Description=" + Description
				+ ", Type=" + Type + ", Userid=" + Userid + "]";
	}
	
    
    
}
