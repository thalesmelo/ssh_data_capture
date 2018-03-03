package com.dataCapture.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月6日
 *
 * @TIME 下午7:39:58
 */
public class Urlutil {

	static HttpURLConnection resumeConnection = null;

	public static String getHtmlByUrl(final String urlString) throws IOException {

		/*
		 * 此类是用来通过url 获取页面的html'
		 */
		// TODO Auto-generated method stub

		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 这个是用来忽略证书验证的代码
		if ("https".equalsIgnoreCase(url.getProtocol())) {
			try {
				SslUtils.ignoreSsl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			resumeConnection = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resumeConnection.setReadTimeout(50000);
		resumeConnection.setConnectTimeout(50000);

		// 把cookie及一些基本参数传入里面
		resumeConnection.setRequestProperty("Accept-Charset", "utf-8");
		resumeConnection.setRequestProperty("Content-Type", "text/html;utf-8");
		resumeConnection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML,"
						+ " like Gecko) Chrome/63.0.3239.108 Safari/537.36");

		resumeConnection.setRequestProperty("Cookie", "_guid=259918863.1484977356988258800.1507290261532.1577");
		resumeConnection.setRequestProperty("Cookie", "_ga=GA1.2.592562837.1507290262");
		resumeConnection.setRequestProperty("Cookie", "_gid=GA1.2.1743520215.1507290262");
		resumeConnection.setRequestProperty("Cookie",
				"cx.PrivateNewsFeedApp.unreadMessages=%7B%22960ee081-0602-4c7f-923d-6ece3a36b024%22%3A0%7D");
		resumeConnection.setRequestProperty("Cookie", "i18next=en-US");
		resumeConnection.setRequestProperty("Cookie", "monitor_count=2");
		resumeConnection.setRequestProperty("Cookie", "remember_token=1612|b612aacfc123949f2f4ced559d502916f284b717");
		resumeConnection.setRequestProperty("Cookie",
				"AWSELB=1723D7C9125EB392546F7E7E36182FB378631ED4801CCB893320EB3A652BCB3235D11A6814D14B69"
						+ "C7A987424728988EF8B6A8CB1DC4FA6D48BCAB7D09529340DFF2F84C2D");
		resumeConnection.setRequestProperty("Cookie", "session=" + CookiesConfig.COOKIE_SESSION);

		try {
			resumeConnection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 使用流来接收从网页获取的html
		InputStream urlStream = null;
		try {
			urlStream = resumeConnection.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(

					new InputStreamReader(urlStream, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String ss = null;
		StringBuffer total = new StringBuffer();
		try {
			while ((ss = bufferedReader.readLine()) != null) {
				total.append(ss + "\n");

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(total);
		bufferedReader.close();
		resumeConnection.disconnect();

		return total.toString();

	}

	// 下载网络上的图片的字节流
	public static String uploadImgByUrl(final String urlString) throws IOException {

		/*
		 * 此类是用来通过url 获取页面的html'
		 */
		// TODO Auto-generated method stub

		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 这个是用来忽略证书验证的代码
		if ("https".equalsIgnoreCase(url.getProtocol())) {
			try {
				SslUtils.ignoreSsl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			resumeConnection = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resumeConnection.setReadTimeout(50000);
		resumeConnection.setConnectTimeout(50000);

		// 把cookie及一些基本参数传入里面
		resumeConnection.setRequestProperty("Accept-Charset", "utf-8");
		resumeConnection.setRequestProperty("Content-Type", "text/html;utf-8");
		resumeConnection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML,"
						+ " like Gecko) Chrome/63.0.3239.108 Safari/537.36");

		resumeConnection.setRequestProperty("Cookie", "_guid=259918863.1484977356988258800.1507290261532.1577");
		resumeConnection.setRequestProperty("Cookie", "_ga=GA1.2.592562837.1507290262");
		resumeConnection.setRequestProperty("Cookie", "_gid=GA1.2.1743520215.1507290262");
		resumeConnection.setRequestProperty("Cookie",
				"cx.PrivateNewsFeedApp.unreadMessages=%7B%22960ee081-0602-4c7f-923d-6ece3a36b024%22%3A0%7D");
		resumeConnection.setRequestProperty("Cookie", "i18next=en-US");
		resumeConnection.setRequestProperty("Cookie", "monitor_count=2");
		resumeConnection.setRequestProperty("Cookie", "remember_token=1612|b612aacfc123949f2f4ced559d502916f284b717");
		resumeConnection.setRequestProperty("Cookie",
				"AWSELB=1723D7C9125EB392546F7E7E36182FB378631ED4801CCB893320EB3A652BCB3235D11A6814D14B69"
						+ "C7A987424728988EF8B6A8CB1DC4FA6D48BCAB7D09529340DFF2F84C2D");
		resumeConnection.setRequestProperty("Cookie", "session=" + CookiesConfig.COOKIE_SESSION);

		try {
			resumeConnection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 使用流来接收从网页获取的html
		InputStream imgStream = null;
		try {
			imgStream = resumeConnection.getInputStream();
		} catch (Exception e) {
			// TODO: handle exception
		}

		byte[] bs = new byte[1024];
		int len;

		File imgFile = new File("D:\\htc_img_folder");
		if (!imgFile.exists()) {
			imgFile.mkdirs();
		}

		String imgurl = imgFile.getPath() + "\\" + imgPath();
		OutputStream osOutputStream = new FileOutputStream(imgurl);

		// 读取
		if (imgStream != null) {
			while ((len = imgStream.read(bs)) != -1) {
				osOutputStream.write(bs, 0, len);
			}

		}
		osOutputStream.close();
		resumeConnection.disconnect();

		return imgurl;

	}

	// 获取存放图片的路径
	public static String imgPath() {
		Progress.Progressing();
		return WebSiteConfig.IMG_Server_Url + WebSiteConfig.WEB_MODULE + "_" + Progress.proIndex + "_"
				+ UUID.randomUUID().toString() + ".PNG";
	}

	// post
	public static String postHtml(String url) throws IOException {
		String param = "{'from':0,'size':15,'sort':{'type':'basic','value':{'key':'created_at','order':'desc','sort':[]}},'facets':[{'type':'terms','value':{'field':'freeform_tags','size':10,'id':'tags'}}],'filter':{'type':'and','value':[{'type':'model_type','value':{'model_type':'album','display':''}},{'type':'term','value':{'field':'gallery_id','filter':1}}]}}";
		byte[] data = param.getBytes("UTF-8");
		URL url2 = new URL("https://elevate.htc.com/search/browse?layout=tile");
		// 这个是用来忽略证书验证的代码
		if ("https".equalsIgnoreCase(url2.getProtocol())) {
			try {
				SslUtils.ignoreSsl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// conn.setRequestProperty("Cookie", "session=" +
		// CookiesConfig.COOKIE_SESSION);
		conn.setRequestProperty("Cookie", "session=" + "090c3a88-b1d0-4dd4-a4be-445b629f1767");
		conn.setRequestProperty("Content-Type", "text/html;utf-8");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		conn.setConnectTimeout(5 * 1000);
		OutputStream outStream = conn.getOutputStream();
		outStream.write(data);
		System.out.println(conn.getResponseCode());
		return null;
	}
}
