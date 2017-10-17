package com.dataCapture.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月6日
 *
 * @TIME 下午7:39:58
 */
public class Urlutil {
	public static String getHtmlByUrl(final String urlString) throws IOException {

		// 博客的主列表网址
		// String s =
		// "https://team.htc.com/blogs/62ae2a94-989d-4aec-b2ff-6b01a9d261d9";

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
		HttpURLConnection resumeConnection = null;
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

		resumeConnection.setRequestProperty("Cookie", "_guid=259918863.1484977356988258800.1507290261532.1577");
		resumeConnection.setRequestProperty("Cookie", "_ga=GA1.2.592562837.1507290262");
		resumeConnection.setRequestProperty("Cookie", "_gid=GA1.2.1743520215.1507290262");
		resumeConnection.setRequestProperty("Cookie",
				"cx.PrivateNewsFeedApp.unreadMessages=%7B%22960ee081-0602-4c7f-923d-6ece3a36b024%22%3A0%7D");
		resumeConnection.setRequestProperty("Cookie", "i18next=en-US");
		resumeConnection.setRequestProperty("Cookie", "monitor_count=8");
		// resumeConnection.setRequestProperty("Cookie", "mmapi.store.p.0=8");

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
		bufferedReader.close();
		resumeConnection.disconnect();

		return total.toString();

	}

}
