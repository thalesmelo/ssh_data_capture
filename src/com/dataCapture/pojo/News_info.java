package com.dataCapture.pojo;

import java.util.List;

/**
 * @author zhuCan
 *
 * @DATE  2017年9月30日
 *
 * @TIME  下午1:56:34
 */
public class News_info {

	private String authorName;
	private String date;
	private List<User_tag> tag;
	private String newsTitle;
	private String imgUrl;
	private List<Label> label;
	private String content;
	private String url;
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
	 * @return the tag
	 */
	public List<User_tag> getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(List<User_tag> tag) {
		this.tag = tag;
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
	public List<Label> getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(List<Label> label) {
		this.label = label;
	}
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
	@Override
	public String toString() {
		return "News_info [作者姓名=" + authorName + "\n 时间=" + date + "\n 作者标签=" + tag + "\n 新闻标题=" + newsTitle
				+ "\n 图片url=" + imgUrl + "\n新闻小标签=" + label + "\n新闻内容=" + content +"\n详情地址URL"+url+ "]";
	}
	
	
}
