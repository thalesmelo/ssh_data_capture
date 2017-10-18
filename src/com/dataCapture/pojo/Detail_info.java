package com.dataCapture.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月7日
 *
 * @TIME 上午10:53:03
 */
@Entity
public class Detail_info {

	private Integer detailId;

	private String author_url;
	private String author_name;
	private Set<User_tag> tags = new HashSet<>();
	private String create_date;
	private String title;
	private String imageUrl;
	private Set<Label> labels = new HashSet<>();
	private String content;
	private String observer_size;
	private String observer_url;

	
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
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "d_l", joinColumns = { @JoinColumn(name = "d_id") }, // teacher表对的id,
			inverseJoinColumns = { @JoinColumn(name = "l_id") })
	public Set<Label> getLabels() {
		return labels;
	}

	/**
	 * @return the tags
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "d_t", joinColumns = { @JoinColumn(name = "d_id") }, // teacher表对的id,
			inverseJoinColumns = { @JoinColumn(name = "t_id") })

	public Set<User_tag> getTags() {
		return tags;
	}

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
	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Set<User_tag> tags) {
		this.tags = tags;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		return "Detail_info [detailId=" + detailId + ", author_name=" + author_name + ", tags=" + tags
				+ ", create_date=" + create_date + ", title=" + title + ", imageUrl=" + imageUrl + ", labels=" + labels
				+ ", content=" + content + ", observer_size=" + observer_size + ", observer_url=" + observer_url + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
}
