package com.dataCapture.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.Enum.WebSite;
import com.dataCapture.bean.UserBean;
import com.dataCapture.htmlFile.FileUtil;
import com.dataCapture.resolver.User_index;
import com.dataCapture.service.UsersService;
import com.dataCapture.util.WebSiteConfig;
import com.dataCapture.util.saveData.UpdateUser;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhuCan
 *
 * @DATE  2018年1月19日
 *
 * @TIME  下午5:31:49
 */
@SuppressWarnings("serial")
public class UsersAction extends ActionSupport{
	@Autowired
	private UsersService usersService;
	
	private Integer websitename;
	private Integer moduleIndex;

	public String user(){
		//WebSiteConfig.init(WebSite.CHAMPIONS);
		
		String html=FileUtil.getHtmlByFile(new File(FileUtil.getUsersFileName()));
	   
		List<UserBean> beans=User_index.getUsers(html);
		
	
		UpdateUser updateUser=new UpdateUser(usersService);		
		updateUser.updateUsers(beans,WebSiteConfig.User_Referer);
		return SUCCESS;
		
		
		
		
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
