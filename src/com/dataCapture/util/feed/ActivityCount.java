package com.dataCapture.util.feed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.dataCapture.pojo.Activity;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.Post;
import com.dataCapture.service.ActivityService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.ForumService;

/**
 * @author zhuCan
 *
 * @DATE 2018年2月7日
 *
 * @TIME 上午9:48:07
 */
public class ActivityCount {
	private ForumService forumService;
	private CommonService commonService;
	private ActivityService activityService;

	public ActivityCount(ForumService forumService, CommonService commonService, ActivityService activityService) {
		this.activityService = activityService;
		this.commonService = commonService;
		this.forumService = forumService;
	}

	public void count() {
		// 查询所有的ac
		List<Activity> activities = activityService.findALL();
		// 循环统计计数
		for (Activity activity : activities) {
			// post计数
			List<Post> posts = forumService.queryByUUID(activity.getUUID());
			//评论计数
			List<Common> commons= commonService.queryByUUID(activity.getUUID());
			
			//计数参与人数
			List<String> uuids=new ArrayList<String>();
			for (Post post : posts) {
				uuids.add(post.getCreateUserId());
			}
			for (Common common : commons) {
				uuids.add(common.getCreateUserUUID());
			}
			
			//去掉重复的人
			HashSet<String> set=new HashSet<String>(uuids);
			uuids.clear();
			uuids.addAll(set);
			
			if (posts!=null) {
				
				activity.setPostNum(posts.size());
			}
			if (commons!=null) {
				
				activity.setCommonNum(commons.size());
			}
			if (uuids!=null) {
				
				activity.setPersonNum(uuids.size());
			}
			
			activityService.update(activity);
		}
	}

}
