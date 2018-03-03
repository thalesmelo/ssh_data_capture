package com.dataCapture.action;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.NewsBean;
import com.dataCapture.resolver.News_Index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.EnumUtil;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveNews;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:50:26
 */
@SuppressWarnings("serial")
public class NewsAction extends ActionSupport{

	@Autowired
	private TagService tagService;
	@Autowired
	private DataCaptureService service;
	@Autowired
	private CommonService commonService;
	
	private Integer websitename;
	private Integer pageIndex;
	private Integer moduleIndex;

	public String saveData() {

		// 初始化参数
		WebSiteConfig.init(EnumUtil.getWebSite(websitename),WebModule.NEWS);

		//登录
		//HtmlUtil.Login();
		
		//下载图片
		//WebSiteConfig.isUploadIMG(true);
		
		//获取新闻列表html....需要传入页数
		//elevate 4页
		//champion 3 页
		//team 1页
		String indexHtml = null;
		try {
			indexHtml = HtmlUtil.getHtml(UrlConfig.News_Index_url(pageIndex));
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 把html转成数据对象集合  (要传入页数)
		List<NewsBean> beans = null;
		beans = News_Index.getIndex(indexHtml,UrlConfig.News_Index_url(pageIndex));
		
		// 开辟新线程从网络加载数据存入数据库
	    SaveNews saveNews=new SaveNews(service, commonService, tagService);
	    saveNews.saveNews(beans);
		return SUCCESS;
	    
	

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
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the moduleIndex
	 */
	public Integer getModuleIndex() {
		return moduleIndex;
	}

	/**
	 * @param moduleIndex the moduleIndex to set
	 */
	public void setModuleIndex(Integer moduleIndex) {
		this.moduleIndex = moduleIndex;
	}
	
	
}
