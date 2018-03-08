package com.dataCapture.util.uploadImgData;

import java.io.IOException;
import java.util.List;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.pojo.Users;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.HtmlUtil;
import com.dataCapture.util.Progress;
import com.dataCapture.util.Urlutil;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月23日
 *
 * @TIME 下午4:19:13
 */
public class UploadUser {
	Thread thread;

	private UsersService usersService;

	public UploadUser(UsersService usersService) {
		this.usersService = usersService;
	}

	public void uploadImg() throws IOException {
		thread = new Thread(new Runnable() {

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				List<Users> users = usersService.findByWebSite();

				for (Users user : users) {
					try {
						thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();Progress.error=true;
					}

					if (user.getWebsiteName() == WebSiteConfig.WEB_SITE) {

						String url = HtmlUtil.openStreamByUrl(user.getHeaderImgUrl(),"https://www.htcchampions.com/community",WebModule.USER,null);
						System.out.println(url);

					}
				}
			}
		});

		thread.start();

	}
}
