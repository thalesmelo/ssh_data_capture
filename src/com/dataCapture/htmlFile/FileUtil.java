package com.dataCapture.htmlFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import com.dataCapture.Enum.WebModule;
import com.dataCapture.util.Progress;
import com.dataCapture.util.WebSiteConfig;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月13日
 *
 * @TIME 下午2:23:26
 */
public class FileUtil {

	public static String getHtmlByFile() {

		// String fileName =
		// "D:/Users/ASUS/eclipse-workspace/ssh_data_capture/WebContent/";

		File file = null;
		if (WebSiteConfig.WEB_MODULE != WebModule.TRAINING) {

			try {
				file = new File(FileUtil.class.getClassLoader().getResource("../../" + WebSiteConfig.FILE_NAME).toURI()
						.getPath());
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Progress.error=true;
			}
		} else {
			try {
				file = new File(FileUtil.class.getClassLoader()
						.getResource("../../" + "training/HTC Champions - Training.html").toURI().getPath());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Progress.error=true;
			}
		}

		BufferedReader reader = null;

		StringBuffer HtmlString = new StringBuffer();

		try {
			reader = new BufferedReader(new FileReader(file));

			String readString = null;
			while ((readString = reader.readLine()) != null) {
				HtmlString.append(readString);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error=true;
		}

		return HtmlString.toString();
	}

	// 获取文件夹中的所有文件
	public static File[] getFilesByFolder() {
		File Folder = null;
		try {
			Folder = new File(FileUtil.class.getClassLoader().getResource("../../" + WebSiteConfig.PHOTO_FOLDER).toURI()
					.getPath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error=true;
		}

		if (!Folder.exists()) {
			System.err.println("文件夹目录不存在!");
			return null;
		}
        WebSiteConfig.setTotalSize(Folder.listFiles().length);
		return Folder.listFiles();
	}

	// 从file读取字符串
	public static String getHtmlByFile(File file) {
		BufferedReader reader = null;

		StringBuffer HtmlString = new StringBuffer();

		try {
			reader = new BufferedReader(new FileReader(file));

			String readString = null;
			while ((readString = reader.readLine()) != null) {
				HtmlString.append(readString);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error=true;
		}

		return HtmlString.toString();
	}

	// 删除文件夹的方法
	public static boolean deleteDir(String sPath) {

		return false;
	}
	
	//获取用户信息的页面
	public static String getUsersFileName(){
		switch (WebSiteConfig.WEB_SITE) {
		case 1:
			try {
				return FileUtil.class.getClassLoader().getResource("../../users/" +"Team HTC - People.html").toURI()
						.getPath();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 2:
			try {
				return FileUtil.class.getClassLoader().getResource("../../users/" +"HTC elevate - People.html").toURI()
						.getPath();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 3:
			try {
				return FileUtil.class.getClassLoader().getResource("../../users/" +"HTC Champions - People.html").toURI()
						.getPath();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		default:
			break;
		}
		return null;
	}
}
