package com.dataCapture.action;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.Enum.WebSite;
import com.dataCapture.bean.ForumBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.resolver.Forum_Index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveForums;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月12日
 *
 * @TIME  下午5:25:24
 */
@SuppressWarnings("serial")
public class ForumsAction extends ActionSupport{
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private TagService tagService;

	public void forum() throws FailingHttpStatusCodeException, MalformedURLException, GeneralSecurityException, IOException, URISyntaxException {
		
		//初始化参数
		WebSiteConfig.init(WebSite.CHAMPIONS,WebModule.FORUM,"Forums");
		
		//登录
		HtmlUtil.Login();
		
		//获取列表html
		String html=FileUtil.getHtmlByFile();
		
		//解析成bean集合
		List<ForumBean> beans=Forum_Index.ForumIndex(html);
		
		//开启线程操作数据
		SaveForums saveForums=new SaveForums(forumService, commonService,tagService);	
		saveForums.save(beans);
		
		
		
	}
}
