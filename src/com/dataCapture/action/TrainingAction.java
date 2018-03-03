package com.dataCapture.action;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dataCapture.Enum.WebModule;
import com.dataCapture.Enum.WebSite;
import com.dataCapture.bean.NewsBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.model.Results;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.News_info;
import com.dataCapture.resolver.News_Index;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.Detail_html;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.NewsUtil;
import com.dataCapture.util.StringConfig;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveNews;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月10日
 *
 * @TIME  上午9:51:05
 */
@SuppressWarnings("serial")
public class TrainingAction extends ActionSupport{
	
	@Autowired
	private  DataCaptureService service;
	@Autowired
	private  CommonService commonService;
	@Autowired
	private TagService tagService;
	
	private Integer websitename;
	private Integer moduleIndex;

	public String training(){
	
		//初始化参数
		WebSiteConfig.init(WebSite.CHAMPIONS,WebModule.TRAINING);
		
		//login
		//HtmlUtil.Login();
				
		//获取html		
		String html=FileUtil.getHtmlByFile();
		
		//把html解析成model对象集合
		List<NewsBean> infos = null;
		infos = News_Index.getIndex(html,"https://www.htcchampions.com/blogs/training");
		
		//启动线程进行数据处理
        SaveNews saveNews=new SaveNews(service, commonService, tagService);
        saveNews.saveNews(infos);
		return SUCCESS;
		
		
	}
	
	public  void saveNews(final List<News_info> infos){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < infos.size(); i++) {
					String html=null;
					//String commonUrl=null;
					
					try {
						// 获取单个详情页的html
						html=HtmlUtil.getHtml(infos.get(i).getUrl());
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Detail_info info=null;
					
					try {
						info=Detail_html.getChampionDetail(html);
					} catch (FailingHttpStatusCodeException | IOException | GeneralSecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					News news=null;
					
					try {
						news=NewsUtil.getNews(infos.get(i), info);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 设置评论的url
					
					info.setObserver_url(UrlConfig.getTrainingObserverUrl(news.getUUID(), info.getObserver_size()));
					//System.out.println(news);
					
					try {
						// 评论存库
						saveCommons(info,news.getUUID());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (GeneralSecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 存入数据库
					service.save(news);
					
				}
			}
		}).start();
	}
	
	public  void saveCommons(Detail_info info, String uuid) throws IOException, FailingHttpStatusCodeException, GeneralSecurityException {

		String observer_url = info.getObserver_url();

		StringBuffer sbBuffer=new StringBuffer();
	    //String jsonString =JSONArray.toJSONString(UrlConfig.getJson(Urlutil.getHtmlByUrl(observer_url)));
	 
		//String commonJson = Urlutil.getHtmlByUrl(observer_url);
		String commonJson =HtmlUtil.getJsonHtml(observer_url);
		//System.out.println(commonJson);
		if (commonJson != null && commonJson.indexOf("\"results\":")>0) {

			
			List<Results> commons= JSON.parseArray(UrlConfig.getJson(commonJson),
					Results.class);

			for (Results bean : commons) {

				Common common = new Common();
				common.setUserName(bean.getAuthor().getAlias());
				common.setComment(bean.getComment());
				common.setDate(new Date((long) (bean.getCreated_at() * 1000)));
				common.setType(2);
				common.setFeature(0);
				common.setLock(0);
				common.setIsDeleted(false);
				common.setUUID(bean.getId());
				common.setParent(uuid);
				common.setCreateDateTime(new Date((long) (bean.getCreated_at() * 1000)));
				String img = bean.getAttachments().toString();
				if (img != null && !"[]".equals(img)) {
					System.err.println(img);
					img = StringConfig.getCommonImgCham(img);
					common.setImageUrl(img);
				}
				common.setCreateUserUUID(bean.getAuthor_id());

				sbBuffer.append("--");
				System.err.println(sbBuffer.toString()+">>>");
			    //存入评论
				commonService.save(common);
				
			
				//System.err.println(common);
				
			}
		}

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
