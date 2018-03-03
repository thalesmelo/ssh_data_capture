package com.dataCapture.pojo;

/**
 * @author zhuCan
 *
 * @DATE  2017年9月30日
 *
 * @TIME  下午1:56:34
 */

public class News_info {

	private Integer Id;
	private String authorName;
	private String date;
	
	private String newsTitle;
	private String imgUrl;
	
	private String content;
	private String url;
	private String Teaser;
	private String UUID;
	
	
	
	
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the newsTitle
	 */
	public String getNewsTitle() {
		return newsTitle;
	}
	/**
	 * @param newsTitle the newsTitle to set
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * @return the label
	 */

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News_info [Id=" + Id + ", authorName=" + authorName + ", date=" + date + ", newsTitle=" + newsTitle
				+ ", imgUrl=" + imgUrl + ", content=" + content + ", url=" + url + ", Teaser=" + Teaser + ", UUID="
				+ UUID + "]";
	}
	
	
}
