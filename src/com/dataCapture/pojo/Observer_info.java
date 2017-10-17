package com.dataCapture.pojo;

import javax.persistence.Column;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月7日
 *
 * @TIME 上午10:58:06
 */

public class Observer_info {

	private String author_name;
	private String commentTime;
	private String comment;
	private String iconUrl;

	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}

	/**
	 * @param author_name
	 *            the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl
	 *            the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return the comment
	 */
	@Column(name = "commont")
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the commentTime
	 */
	public String getCommentTime() {
		return commentTime;
	}

	/**
	 * @return the author
	 */

	/**
	 * @param commentTime
	 *            the commentTime to set
	 */
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Observer_info {" + ", author_name=" + author_name + ", commentTime=" + commentTime + ", comment="
				+ comment + ", iconUrl=" + iconUrl + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

}
