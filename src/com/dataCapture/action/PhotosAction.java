package com.dataCapture.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.AlbumBean;
import com.dataCapture.bean.PhotoBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.resolver.Album_index;
import com.dataCapture.service.AlbumService;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.PhotoService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.EnumUtil;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.SaveAlbum;
import com.dataCapture.util.saveData.SavePhotos;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月19日
 *
 * @TIME 下午3:55:06
 */
@SuppressWarnings("serial")
public class PhotosAction extends ActionSupport {
	@Autowired
	private AlbumService albumService;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private TagService tagService;

	private Integer websitename;
	private Integer moduleIndex;

	public String photo() {
		// 初始化
		WebSiteConfig.init(EnumUtil.getWebSite(websitename), WebModule.PHOTO);

		// 登录
		// HtmlUtil.Login();

		// 下载图片
		// WebSiteConfig.isUploadIMG(true);

		// 获取photo的所有file
		final File[] files = FileUtil.getFilesByFolder();

		// 开线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (File file : files) {
					// 读取主页面
					String html = FileUtil.getHtmlByFile(file);

					// 解析成相册对象进行存库
					AlbumBean bean = Album_index.getAlbum(html);
					SaveAlbum saveAlbum = new SaveAlbum(albumService, tagService);
					saveAlbum.saveAlbum(bean);

					// 解析转换为图片bean
					List<PhotoBean> beans = Album_index.photo_index(html, bean);
					SavePhotos savePhotos = new SavePhotos(photoService, commonService, tagService);
					try {
						savePhotos.save(beans);
					} catch (FailingHttpStatusCodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 进行存库
				}
			}
		}).start();
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
