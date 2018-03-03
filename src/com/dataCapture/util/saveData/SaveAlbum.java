package com.dataCapture.util.saveData;

import com.dataCapture.bean.AlbumBean;
import com.dataCapture.pojo.Photos;
import com.dataCapture.pojo.Tags;
import com.dataCapture.reflectTest.CopyObject;
import com.dataCapture.service.AlbumService;
import com.dataCapture.service.TagService;
import com.dataCapture.util.Progress;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月24日
 *
 * @TIME 下午2:02:29
 */
public class SaveAlbum {

	private AlbumService albumService;
	private TagService tagService;

	public SaveAlbum(AlbumService albumService, TagService tagService) {
		this.albumService = albumService;
		this.tagService = tagService;
	}

	public void saveAlbum(AlbumBean albumBean) {

		Photos album = (Photos) CopyObject.copy(albumBean, new Photos());
		 albumService.save(album);
		String tags = albumBean.getTag();
		if (tags != null && !"".equals(tags)) {
			String[] tagString = tags.split(",");
			for (String tag : tagString) {
				Tags tags2 = new Tags();
				tags2.setCreateDateTime(albumBean.getCreateDateTime());
				tags2.setModuleId(albumBean.getUUID());
				tags2.setName(tag);
				tags2.setTagGype(1);
			    tagService.save(tags2);
			}
		}
		
		Progress.Progressing();

	}
}
