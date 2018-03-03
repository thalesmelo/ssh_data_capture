package com.dataCapture.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.service.ActivityFeedService;
import com.dataCapture.service.ActivityService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.feed.ActivityCount;
import com.dataCapture.util.feed.NewsFeed;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月6日
 *
 * @TIME  下午4:09:15
 */
@SuppressWarnings("serial")
public class ActivityFeedAction extends ActionSupport{

	@Autowired
	private DataCaptureService newsService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private ActivityFeedService activityFeedService;
	@Autowired
	private ForumService forumService;
	@Autowired
	private ActivityService activityService;
	
	private Integer websitename;
	private Integer pageIndex;
	private Integer moduleIndex;
	
	public String feed(){
		
		NewsFeed feed=new NewsFeed(usersService, commonService, newsService,activityFeedService);
		feed.addFeed();
		
		return SUCCESS;
	}
	
	public String actCount(){
		
		ActivityCount count=new ActivityCount(forumService, commonService, activityService);
		count.count();
		
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
