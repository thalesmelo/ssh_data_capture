package com.dataCapture.util.feed;

import java.util.List;

import com.dataCapture.pojo.ActivityFeed;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.Users;
import com.dataCapture.service.ActivityFeedService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.UsersService;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月6日
 *
 * @TIME  下午4:13:11
 */
public class NewsFeed {

	private UsersService usersService;
	private CommonService commonService;
	private  DataCaptureService newsService;
	private ActivityFeedService activityFeedService;
	
	
	
	public NewsFeed(UsersService usersService,CommonService commonService,DataCaptureService newsService, ActivityFeedService activityFeedService){
		this.commonService=commonService;
		this.newsService=newsService;
		this.usersService=usersService;
		this.activityFeedService=activityFeedService;
	}
	
	public  void addFeed(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				List<News> news=newsService.allByWebSite();
				
				//先存news的记录
				for (News info : news) {
					ActivityFeed feed=new ActivityFeed();
					feed.setCreateDateTime(info.getCreateDateTime());
					feed.setObjectId(info.getUUID());
					feed.setObjectName(info.getTitle());
				
					Users users=usersService.query(info.getCreateUserId());
					feed.setSubjectId(users.getUUID());
					feed.setSubjectType(14);
					feed.setSubjectUserImgUrl(users.getHeaderImgUrl());
					feed.setSubjectUserName(users.getRealName());
					
					feed.setWebsiteName(info.getWebsiteName());
					
					activityFeedService.save(feed);
				}
				
				//存评论的记录
				for (News info : news) {
					//评论
					List<Common> commons=(List<Common>) commonService.findByParent(info.getUUID());
					for (Common common : commons) {
						ActivityFeed feed=new ActivityFeed();
						feed.setCreateDateTime(common.getCreateDateTime());
						feed.setObjectId(common.getUUID());
						feed.setObjectName(info.getTitle());
						feed.setObjectUrl("news/censor/"+info.getUUID());
					
						Users users=usersService.query(common.getCreateUserUUID());
						if (users==null) {
							continue;
						}
						feed.setSubjectId(users.getUUID());
						feed.setSubjectType(1);
						feed.setSubjectUserImgUrl(users.getHeaderImgUrl());
						feed.setSubjectUserName(users.getRealName());
						
						
						
						feed.setWebsiteName(info.getWebsiteName());
						
						activityFeedService.save(feed);
					}
					
					//回复
					List<Common> replys=(List<Common>) commonService.replyByParent(info.getUUID());
					for (Common common : replys) {
						ActivityFeed feed=new ActivityFeed();
						feed.setCreateDateTime(common.getCreateDateTime());
						feed.setObjectId(common.getUUID());
						feed.setObjectName(info.getTitle());
						feed.setObjectUrl("news/censor/"+info.getUUID());
					
						Users users=usersService.query(common.getCreateUserUUID());
						if (users==null) {
							continue;
						}
						feed.setSubjectId(users.getUUID());
						feed.setSubjectType(10);
						feed.setSubjectUserImgUrl(users.getHeaderImgUrl());
						feed.setSubjectUserName(users.getRealName());
						
						feed.setWebsiteName(info.getWebsiteName());
						
						activityFeedService.save(feed);
					}
					
				}
				
				
			}
			
		}).start();
		
		
		
	}
}
