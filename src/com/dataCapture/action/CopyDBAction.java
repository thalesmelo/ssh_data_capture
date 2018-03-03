package com.dataCapture.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.pojo.ActivityModel;
import com.dataCapture.pojo.ActivityModel_copy;
import com.dataCapture.pojo.Common;
import com.dataCapture.pojo.Common_copy;
import com.dataCapture.pojo.News;
import com.dataCapture.pojo.News_copy;
import com.dataCapture.pojo.Photos;
import com.dataCapture.pojo.PhotosImg;
import com.dataCapture.pojo.PhotosImg_copy;
import com.dataCapture.pojo.Photos_copy;
import com.dataCapture.pojo.Post;
import com.dataCapture.pojo.Post_copy;
import com.dataCapture.pojo.Tags;
import com.dataCapture.pojo.Tags_copy;
import com.dataCapture.reflectTest.CopyObject;
import com.dataCapture.service.ActivityModelService;
import com.dataCapture.service.ActivityModelService_copy;
import com.dataCapture.service.AlbumService;
import com.dataCapture.service.AlbumService_copy;
import com.dataCapture.service.CommonService;
import com.dataCapture.service.CommonService_copy;
import com.dataCapture.service.DataCaptureService;
import com.dataCapture.service.DataCaptureService_copy;
import com.dataCapture.service.ForumService;
import com.dataCapture.service.ForumService_copy;
import com.dataCapture.service.PhotoService;
import com.dataCapture.service.PhotoService_copy;
import com.dataCapture.service.TagService;
import com.dataCapture.service.TagService_copy;
import com.dataCapture.util.Progress;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 * @param <K>
 *
 * @DATE 2018年1月31日
 *
 * @TIME 上午10:01:37
 */
@SuppressWarnings("serial")
public class CopyDBAction extends ActionSupport {

	@Autowired
	private DataCaptureService DataCaptureService;
	@Autowired
	private DataCaptureService_copy DataCaptureService_copy;
	@Autowired
	private CommonService CommonService;
	@Autowired
	private CommonService_copy CommonService_copy;
	@Autowired
	private ForumService_copy ForumService_copy;
	@Autowired
	private ForumService ForumService;
	@Autowired
	private TagService TagService;
	@Autowired
	private TagService_copy TagService_copy;
	@Autowired
	private AlbumService_copy AlbumService_copy;
	@Autowired
	private AlbumService AlbumService;
	@Autowired
	private PhotoService PhotoService;
	@Autowired
	private PhotoService_copy photoService_copy;
	@Autowired
	private ActivityModelService activityModelService;
	@Autowired
	private ActivityModelService_copy activityModelService_copy;

	// 增量操作表的action
	public void copyData() {
		Progress.resetProgress();

		doCopy(DataCaptureService, DataCaptureService_copy, new News(), new News_copy());
		doCopy(CommonService, CommonService_copy, new Common(), new Common_copy());
		doCopy(ForumService, ForumService_copy, new Post(), new Post_copy());
		doCopy(TagService, TagService_copy, new Tags(), new Tags_copy());
		doCopy(AlbumService, AlbumService_copy, new Photos(), new Photos_copy());
		doCopy(PhotoService, photoService_copy, new PhotosImg(), new PhotosImg_copy());
		doCopy(activityModelService, activityModelService_copy, new ActivityModel(), new ActivityModel_copy());

	}

	@SuppressWarnings("unchecked")
	public <T, K, T1, K1> boolean doCopy(T service, T1 service_copy, K pojo, K1 pojo_copy) {

		List<K> pojoList = new ArrayList<>();
		// 查出数据库表的数据
		try {
			pojoList = (List<K>) service.getClass().getMethod("queryAll", new Class[] {}).invoke(service,
					new Class[] {});
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;

		}

		// 转换pojo
		for (K item : pojoList) {
			pojo_copy = (K1) CopyObject.copy(item, pojo_copy);
			// 把数据添加到_copy表中

			try {
				service_copy.getClass().getMethod("save", new Class[] { pojo_copy.getClass() }).invoke(service_copy,
						pojo_copy);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Progress.error = true;

			}

		}

		// 删除原先表中的数据
		try {
			service.getClass().getMethod("deleteAll", new Class[] {}).invoke(service, new Class[] {});
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;

		}
		return true;
	}
}
