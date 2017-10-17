package com.dataCapture.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dataCapture.model.ObserverBean;
import com.dataCapture.pojo.Detail_info;
import com.dataCapture.pojo.News_info;
import com.dataCapture.pojo.Observer_info;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.util.CookiesConfig;
import com.dataCapture.util.Detail_html;
import com.dataCapture.util.Index_html;
import com.dataCapture.util.UrlConfig;
import com.dataCapture.util.Urlutil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月9日
 *
 * @TIME 下午2:50:26
 */
public class DataCaptureAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myCookie;
	private Map<String, Object> session;
	private Integer maxSize;
	private Integer id;
	private Detail_info info;
	private List<Observer_info> observer_info;

	@Autowired
	private DataCaptureService service;

	public String saveData() throws IOException {

		// 先从网站把session存入

		CookiesConfig.COOKIE_SESSION = "1df4f9c5-b6c3-44a0-a6c0-70f631a20e12";
		CookiesConfig.COOKIE_SESSION = myCookie;
		System.out.println(myCookie);
		// 博客的主列表网址
		String s = "https://team.htc.com/blogs/62ae2a94-989d-4aec-b2ff-6b01a9d261d9";

		// 获取主页面的html
		String indexHtml = Urlutil.getHtmlByUrl(s);

		// 把html转成数据对象集合
		List<News_info> infos = Index_html.getIndex(indexHtml);

		maxSize = infos.size();

		// 开辟新线程从网络加载数据存入数据库
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < infos.size(); i++) {
					String html = null;
					String observer_url = null;
					try {
						// 获取单个详情页的html
						html = Urlutil.getHtmlByUrl(infos.get(i).getUrl());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Detail_info info = null;

					// 把html解析成对象
					try {
						// 获取对象
						info = Detail_html.getDetail(html);
						// 设置评论的url
						String keyUrl = UrlConfig.getKeyUrl(infos.get(i).getUrl());

						observer_url = UrlConfig.getObserverUrl(keyUrl, info.getObserver_size());
						info.setObserver_url(observer_url);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 存入数据库
					service.save(info);

				}
			}
		}).start();

		return SUCCESS;

	}

	public String queryById() throws IOException {
		info = service.queryById(Detail_info.class, id);

		String observer_url = info.getObserver_url();

		List<ObserverBean> beans = JSON.parseArray(UrlConfig.getJson(Urlutil.getHtmlByUrl(observer_url)),
				ObserverBean.class);

		observer_info = new ArrayList<>();
		for (ObserverBean observerBean : beans) {
			Observer_info obser = new Observer_info();
			obser.setAuthor_name(observerBean.getAuthor().getAlias());
			obser.setComment(observerBean.getComment().replace("<p>", "").replace("</p>", ""));
			obser.setIconUrl(UrlConfig.getIconUrl(observerBean.getAuthor_id()));
			observer_info.add(obser);
			// System.err.println(obser);
		}
		return SUCCESS;
	}

	/**
	 * @return the myCookie
	 */
	public String getMyCookie() {
		return myCookie;
	}

	/**
	 * @param myCookie
	 *            the myCookie to set
	 */
	public void setMyCookie(String myCookie) {
		this.myCookie = myCookie;
	}

	/**
	 * @return the maxSize
	 */
	public Integer getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize
	 *            the maxSize to set
	 */
	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the info
	 */
	public Detail_info getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(Detail_info info) {
		this.info = info;
	}

	/**
	 * @return the observer_info
	 */
	public List<Observer_info> getObserver_info() {
		return observer_info;
	}

	/**
	 * @param observer_info
	 *            the observer_info to set
	 */
	public void setObserver_info(List<Observer_info> observer_info) {
		this.observer_info = observer_info;
	}

}
