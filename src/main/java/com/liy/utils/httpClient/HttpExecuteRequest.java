/**
 * 
 */
package com.liy.utils.httpClient;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * @author liyong
 * @date 2021年2月9日
 * @time 下午4:08:51
 * 执行请求
 */
public class HttpExecuteRequest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.custom().build();
		String url = "https://www.bilibili.com/";
		HttpContext httpContext = new BasicHttpContext();
		
		// 创建请求方法实例
		HttpGet httpGet = new HttpGet(url);
//		System.out.println(httpGet);
		// 执行请求
		HttpResponse response = httpClient.execute(httpGet, httpContext);
		System.out.println("版本信息"+response.getProtocolVersion());
		System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
		
		//取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
        	EntityUtils.consume(entity);
        	// 把内容转成字符串
//        	String string = EntityUtils.toString(entity, "utf-8");
//        	System.out.println(string);
        }
        //关闭httpclient
        ((Closeable) response).close();
	}

}
