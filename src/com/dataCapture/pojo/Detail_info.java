package com.dataCapture.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月7日
 *
 * @TIME 上午10:53:03
 */
//@Entity
public class Detail_info {

	private Integer detailId;

	private String author_url;
	private String author_name;
	private String FeaturedImageUrl;
	private String Teaser;
	private String CreateUserId;
	private String UUID;
	private Boolean isLock;
	private Boolean Feature;
	private String tags ;
	private String create_date;
	private String title;
	private String imageUrl;
	private String labels ;
	private String content;
	private String observer_size;
	private String observer_url;

	
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
	 * @return the teaser
	 */
	public String getTeaser() {
		return Teaser;
	}

	/**
	 * @param teaser the teaser to set
	 */
	public void setTeaser(String teaser) {
		Teaser = teaser;
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
	 * @return the observer_size
	 */
	public String getObserver_size() {
		return observer_size;
	}

	/**
	 * @param observer_size
	 *            the observer_size to set
	 */
	public void setObserver_size(String observer_size) {
		this.observer_size = observer_size;
	}

	/**
	 * @return the observer_url
	 */
	public String getObserver_url() {
		return observer_url;
	}

	/**
	 * @param observer_url
	 *            the observer_url to set
	 */
	public void setObserver_url(String observer_url) {
		this.observer_url = observer_url;
	}

	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the date
	 */

	/**
	 * @return the detailId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	public Integer getDetailId() {
		return detailId;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @return the labels
	 */
	//@ManyToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "d_l", joinColumns = { @JoinColumn(name = "d_id") }, // teacher表对的id,
	//		inverseJoinColumns = { @JoinColumn(name = "l_id") })
	/*public Set<Label> getLabels() {
		return labels;
	}*/

	/**
	 * @return the tags
	 */
	//@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "d_t", joinColumns = { @JoinColumn(name = "d_id") }, // teacher表对的id,
	//		inverseJoinColumns = { @JoinColumn(name = "t_id") })
	/*public Set<User_tag> getTags() {
		return tags;
	}*/

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param author_name
	 *            the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param date
	 *            the date to set
	 */

	/**
	 * @param detailId
	 *            the detailId to set
	 */
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	/**
	 * @return the create_date
	 */
	public String getCreate_date() {
		return create_date;
	}

	/**
	 * @param create_date
	 *            the create_date to set
	 */
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @param labels
	 *            the labels to set
	 */
/*	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	*//**
	 * @param tags
	 *            the tags to set
	 *//*
	public void setTags(Set<User_tag> tags) {
		this.tags = tags;
	}
*/
	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the labels
	 */
	public String getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String labels) {
		this.labels = labels;
	}

	/**
	 * @return the author_url
	 */
	public String getAuthor_url() {
		return author_url;
	}

	/**
	 * @param author_url the author_url to set
	 */
	public void setAuthor_url(String author_url) {
		this.author_url = author_url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Detail_info [detailId=" + detailId + ", author_url=" + author_url + ", author_name=" + author_name
				+ ", FeaturedImageUrl=" + FeaturedImageUrl + ", Teaser=" + Teaser + ", CreateUserId=" + CreateUserId
				+ ", UUID=" + UUID + ", isLock=" + isLock + ", Feature=" + Feature + ", tags=" + tags + ", create_date="
				+ create_date + ", title=" + title + ", imageUrl=" + imageUrl + ", labels=" + labels + ", content="
				+ content + ", observer_size=" + observer_size + ", observer_url=" + observer_url + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
}
