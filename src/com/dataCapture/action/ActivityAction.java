package com.dataCapture.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.ForumBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.resolver.Forum_Index;
import com.dataCapture.service.ActivityModelService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.PhotoService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.EnumUtil;
import com.dataCapture.util.TitleUtil;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveForums;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月19日
 *
 * @TIME 上午10:21:16
 */
@SuppressWarnings("serial")
public class ActivityAction extends ActionSupport {
	@Autowired
	private ForumService forumService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private TagService tagService;
	@Autowired
	private ActivityModelService activityModelService;
	@Autowired
	private PhotoService photoService;
	
	private Integer websitename;
	private Integer pageIndex;
	private Integer moduleIndex;

	// 标题数组
    // champion  2个
	// elevate 3个
	// team   1个
	public String activity(){
		// 初始化 注意填写标题
		WebSiteConfig.init(EnumUtil.getWebSite(websitename), WebModule.ACTIVITY, TitleUtil.getACT_Title(EnumUtil.getWebSite(websitename), pageIndex));

		//HtmlUtil.Login();
		
		//WebSiteConfig.isUploadIMG(true);

		String html = null;
		html = FileUtil.getHtmlByFile();

		List<ForumBean> beans = Forum_Index.ForumIndex(html);

		SaveForums saveForums = new SaveForums(forumService, commonService, tagService,activityModelService,photoService);
		saveForums.save(beans);
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
