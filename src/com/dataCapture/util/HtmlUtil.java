package com.dataCapture.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.UUID;

import com.dataCapture.Enum.WebModule;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebConnection;
import com.gargoylesoftware.htmlunit.WebRequestSettings;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月10日
 *
 * @TIME 下午1:22:42
 */
public class HtmlUtil {

	private static WebClient client = new WebClient();

	// 网站登入
	public static void Login() {
		try {
			client.setUseInsecureSSL(true);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		client.setCssEnabled(false);
		client.setThrowExceptionOnScriptError(false);
		client.setJavaScriptEnabled(true);
		client.setThrowExceptionOnFailingStatusCode(false);
		client.setCookiesEnabled(true);
		WebClient.setJavaScriptTimeout(20000);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

		// 获取登录页面
		HtmlPage loginPage = null;
		try {
			loginPage = (HtmlPage) client.getPage(WebSiteConfig.Login_Url);
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		HtmlForm form = (HtmlForm) loginPage.getHtmlElementById("login-form");

		// 获取账户密码input
		HtmlInput name = form.getInputByName("email");
		name.setValueAttribute(WebSiteConfig.ACCOUNT);
		HtmlInput pass = form.getInputByName("password");
		pass.setValueAttribute(WebSiteConfig.Password);

		// 获取提交按钮
		HtmlButton suButton = (HtmlButton) form.getHtmlElementsByTagName("button").get(0);

		// 登录
		try {
			HtmlPage signIn = (HtmlPage) suButton.click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		System.out.println("Login is OK!!!");

	}

	// 登录后获取指定的页面
	public static String getHtml(String urlString) {

		HtmlPage page = null;
		try {
			page = (HtmlPage) client.getPage(urlString);
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}

		return page.getWebResponse().getContentAsString();

	}

	// 获取ajax加载页面
	public static String getAjaxHtml(String url) {
		HtmlPage page = null;
		try {
			page = (HtmlPage) client.getPage(url);
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		synchronized (page) {

			try {
				page.wait(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Progress.error = true;
			}
		}

		final String pageAsXml = page.asXml();
		System.out.println(pageAsXml);
		return null;
	}

	// 获取json页面
	public static String getJsonHtml(String url) {
		if (url == null || "".equals(url)) {
			return null;
		}
		Page page = null;
		try {
			page = client.getPage(url);
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}

		return page.getWebResponse().getContentAsString();
	}

	// 打开连接的io流,用来下载图片

	public static String openStreamByUrl(String url, String Referer, WebModule module) {

		if (url == null || "".equals(url)) {
			return null;
		}

		WebConnection connection = client.getWebConnection();

		WebRequestSettings requestSettings = null;
		try {
			requestSettings = new WebRequestSettings(new URL(url));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Progress.error = true;
		}

		requestSettings.addAdditionalHeader("Referer", Referer);

		WebResponse response = null;
		try {
			response = connection.getResponse(requestSettings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		if (response==null) {
			
			Progress.error = true;
			return null;
		}

		InputStream inputStream = null;
		try {
			
			inputStream = response.getContentAsStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		/*
		 * Page page =null; try { page = client.getPage(url); } catch
		 * (FailingHttpStatusCodeException | IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } InputStream
		 * inputStream =null; try { inputStream =
		 * page.getWebResponse().getContentAsStream(); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); return url; }
		 */
		byte[] bs = new byte[1024];
		int len;

		File imgFile = new File("D:\\htc_img_folder\\" + module.toString().toLowerCase());
		if (!imgFile.exists()) {
			imgFile.mkdirs();
		}

		String imgServerPath=imgPath(module);
		String imgurl = imgFile.getPath() + "\\" + imgServerPath;
		OutputStream osOutputStream = null;
		try {
			osOutputStream = new FileOutputStream(imgurl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}

		// 读取
		if (inputStream != null) {
			try {
				while ((len = inputStream.read(bs)) != -1) {
					osOutputStream.write(bs, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Progress.error = true;
			}

		} else {
			return url;
		}
		try {
			osOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Progress.error = true;
		}

		Progress.imgProgressinng();
		
		return WebSiteConfig.IMG_Server_Url + module.toString().toLowerCase() + "/"
				+ imgServerPath;
	}

	// 存放图片的路径
	public static String imgPath(WebModule module) {

		return module.toString().toLowerCase() + "-" + UUID.randomUUID().toString() + ".png";
	}

}
