package com.dataCapture.util.saveData;

import java.util.List;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.bean.UserBean;
import com.dataCapture.pojo.Users;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.Progress;
import com.dataCapture.util.uploadImgData.ImgUtil;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月19日
 *
 * @TIME  下午5:43:19
 */
public class UpdateUser {
	
	private UsersService usersService;
	Thread thread;
	
	public UpdateUser(UsersService usersService){
		this.usersService=usersService;
	}

	public void updateUsers(final List<UserBean> beans,final String referer){
	 thread=new Thread(new Runnable() {
			
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (UserBean userBean : beans) {
					Users users=usersService.query(userBean.getUUID());
					Progress.Progressing();
					if (users!=null) {
						
						/*try {
							thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();Progress.error=true;
						}*/
						users.setHeaderImgUrl(userBean.getHeaderImgUrl());
						users.setCreateDateTime(userBean.getCreateDateTime());
						users.setHeaderImgUrl(ImgUtil.upImg(users.getHeaderImgUrl(), referer, WebModule.USER));
						usersService.update(users);
					
					}
					
				}
			}
		});
	 thread.start();
		
	}
	
	
	
}
