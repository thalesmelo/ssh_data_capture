package com.dataCapture.action;

import com.dataCapture.Enum.WebSite;
import com.dataCapture.util.EnumUtil;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.WebSiteConfig;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月30日
 *
 * @TIME 下午3:06:24
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private Integer websitename;
	private WebSite webSite;
	private String isUplodaImg;
	


	// 登录的action
	public String login() {
		webSite = EnumUtil.getWebSite(websitename);
		WebSiteConfig.init(webSite);
		WebSiteConfig.isUploadIMG(isUplodaImg.equals("yes"));

		try {
			// 登录
			HtmlUtil.Login();
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}






	/**
	 * @return the isUplodaImg
	 */
	public String getIsUplodaImg() {
		return isUplodaImg;
	}






	/**
	 * @param isUplodaImg the isUplodaImg to set
	 */
	public void setIsUplodaImg(String isUplodaImg) {
		this.isUplodaImg = isUplodaImg;
	}






	/**
	 * @return the websitename
	 */
	public Integer getWebsitename() {
		return websitename;
	}



	/**
	 * @param websitename the websitename to set
	 */
	public void setWebsitename(Integer websitename) {
		this.websitename = websitename;
	}



	/**
	 * @return the webSite
	 */
	public WebSite getWebSite() {
		return webSite;
	}



	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(WebSite webSite) {
		this.webSite = webSite;
	}

	

}
