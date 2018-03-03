package com.dataCapture.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.News_info;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月8日
 *
 * @TIME  下午2:25:22
 */
public class NewsUtil {
	
	public static News getNews(News_info news_info,Detail_info detail_info) throws ParseException{
		News news=new News();
		news.setBody(detail_info.getContent());
		news.setCreateDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(news_info.getDate().replace("T", " ").replace("Z", " ")));
		news.setCreateUserId(detail_info.getCreateUserId());
		news.setFeaturedImageUrl(news_info.getImgUrl());
		news.setImageUrl(detail_info.getImageUrl());
		news.setIsDeleted(false);
		news.setIsLock(false);
		news.setViewNum(0);
		news.setLoveNum(0);
		news.setScheduled(false);
		news.setStatus(1);
		//news.setTag(detail_info.getLabels());
		news.setTeaser(news_info.getContent());
		news.setTitle(detail_info.getTitle());
		news.setUUID(news_info.getUUID().length()>5?news_info.getUUID():detail_info.getUUID());
		news.setWebsiteName(WebSiteConfig.WEB_SITE);
		news.setOrderId(0);
		news.setBlogId(2);
		news.setFeature(false);
		news.setVisibleLevel(1);
		return news;
	}

}
