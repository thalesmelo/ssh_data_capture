package com.dataCapture.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhuCan
 *
 * @DATE 2018年1月11日
 *
 * @TIME 上午10:15:47
 */
public class HttpClientUtil {

	public static String post(String urlstring) throws HttpException, IOException {

		URL url = new URL(urlstring);

		if ("https".equalsIgnoreCase(url.getProtocol())) {
			try {
				SslUtils.ignoreSsl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String param = "{'from':0,'size':15,'sort':{'type':'basic','value':{'key':'created_at','order':'desc','sort':[]}},'facets':[{'type':'terms','value':{'field':'freeform_tags','size':10,'id':'tags'}}],'filter':{'type':'and','value':[{'type':'model_type','value':{'model_type':'album','display':''}},{'type':'term','value':{'field':'gallery_id','filter':1}}]}}";

		JSONObject jsonObject = JSONObject.parseObject(param);

		StringEntity entity=new StringEntity(jsonObject.toString(),Charset.forName("UTF-8"));
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
	
		
		
		HttpClient client = new HttpClient();

		HttpMethod method = new PostMethod("https://elevate.htc.com/search/browse?layout=tile");

		method.setQueryString(param);
		
		method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		client.getState().addCookie(new Cookie(".elevate.htc.com", "session", "090c3a88-b1d0-4dd4-a4be-445b629f1767"));

		client.executeMethod(method);

		System.out.println(method.getStatusCode());

		System.err.println(method.getResponseBodyAsString());
		return null;
	}

    public static void posttest(String urlstring) throws HttpException, IOException{
    	HttpClient client=new HttpClient();
    	PostMethod post1=new PostMethod(urlstring);
    	String param = "{'from':0,'size':15,'sort':{'type':'basic','value':{'key':'created_at','order':'desc','sort':[]}},'facets':[{'type':'terms','value':{'field':'freeform_tags','size':10,'id':'tags'}}],'filter':{'type':'and','value':[{'type':'model_type','value':{'model_type':'album','display':''}},{'type':'term','value':{'field':'gallery_id','filter':1}}]}}";

    	client.getState().addCookie(new Cookie(".elevate.htc.com", "session", "090c3a88-b1d0-4dd4-a4be-445b629f1767"));
		RequestEntity entity=new StringRequestEntity(param,"application/json","UTF-8");
		post1.setRequestEntity(entity);
        client.executeMethod(post1);


		System.out.println(post1.getStatusCode());

		System.err.println(post1.getResponseBodyAsString());
		
		
    }
}