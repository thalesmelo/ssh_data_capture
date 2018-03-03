package com.dataCapture.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.ForumBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.resolver.Forum_Index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.EnumUtil;
import com.dataCapture.util.TitleUtil;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveForums;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月18日
 *
 * @TIME 下午3:37:45
 */
@SuppressWarnings("serial")
public class DisscussionAction extends ActionSupport {
	@Autowired
	private ForumService forumService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private TagService tagService;

	private Integer websitename;
	private Integer pageIndex;
	private Integer moduleIndex;

	// 标题数组
	// champion 8个
	public static String[] Titles_champion = { "Forums", "Status Feed",
			"Introduce yourself and get to know other members!", "HTC Champions Silver/Gold/Champion Hangout!",
			"Video: Android 7.0 Nougat on HTC One A9!", "Video: Top 5 Features of the HTC 10!",
			"Video: HTC Bolt vs. HTC 10!", "Video: Android 7.0 Nougat on HTC 10!" };

	// elevate 16个
	public static String[] titles_elevate = { "Elevate Elite Task Force: HTC U11", "Elevate Gold Member Hangout!",
			"Ultimate Elevater Private Hangout!", "Elevate Chat Room: Europe",
			"Elevate Chat Room: Australia/New Zealand", "Elevate Chat Room: South Asia", "Elevate Chat Room: Americas",
			"Elevate Chat Room: India", "Elevate Coffee Shop", "Want to be featured on HTC's social ...",
			"What was your first HTC smartphone?", "Forums", "Video: Camera modes on HTC U Ultra!",
			"Introduce Yourself and Get to Know ...", "Member Help and How To", "Platform Training Videos" };
	// team 7个

	public String disscussion() {
		// 初始化 1.网站 2.模块 3.标题
		WebSiteConfig.init(EnumUtil.getWebSite(websitename), WebModule.DISSCUSSION,
				TitleUtil.getDis_Title(EnumUtil.getWebSite(websitename), pageIndex));

		// HtmlUtil.Login();

		// 设置为true为下载图片
		// WebSiteConfig.isUploadIMG(true);

		String html = null;
		html = FileUtil.getHtmlByFile();

		List<ForumBean> beans = Forum_Index.ForumIndex(html);

		SaveForums saveForums = new SaveForums(forumService, commonService, tagService);
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
	 * @param websitename
	 *            the websitename to set
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
	 * @param pageIndex
	 *            the pageIndex to set
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
