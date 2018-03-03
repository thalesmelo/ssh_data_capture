package com.dataCapture.action;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.Enum.WebSite;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.CookiesConfig;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.uploadImgData.UploadUser;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月23日
 *
 * @TIME  下午3:43:56
 */
public class ImgAction extends ActionSupport{

	@Autowired
	private  DataCaptureService newsService;
	@Autowired
	private ForumService postSservice;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UsersService usersService;
	
	
	public void uploadImg() throws IOException, FailingHttpStatusCodeException, GeneralSecurityException{
		
		WebSiteConfig.init(WebSite.CHAMPIONS,WebModule.NEWS);
		
		CookiesConfig.COOKIE_SESSION="f056559e-675d-4553-98e4-20dc1c4fd081";
		
		HtmlUtil.Login();
		
		UploadUser uploadUser=new UploadUser(usersService);		
		uploadUser.uploadImg();
	}
	
}
