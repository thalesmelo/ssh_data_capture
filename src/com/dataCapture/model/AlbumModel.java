package com.dataCapture.model;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月10日
 *
 * @TIME  上午10:11:16
 */
public class AlbumModel {

	//每个相册的url
	private String ItemUrl;
	//封面主图的url
	private String imgUrl;
	//每个相册的图片数量
	private String imgCount;
	/**
	 * @return the itemUrl
	 */
	public String getItemUrl() {
		return ItemUrl;
	}
	/**
	 * @param itemUrl the itemUrl to set
	 */
	public void setItemUrl(String itemUrl) {
		ItemUrl = itemUrl;
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
	 * @return the imgCount
	 */
	public String getImgCount() {
		return imgCount;
	}
	/**
	 * @param imgCount the imgCount to set
	 */
	public void setImgCount(String imgCount) {
		this.imgCount = imgCount;
	}
	
	
}
