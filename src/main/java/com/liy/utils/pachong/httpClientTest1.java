/**
 * 
 */
package com.liy.utils.pachong;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong
 * @date 2021年2月10日
 * @time 下午3:52:20
 */
public class httpClientTest1 {
	// 创建httpClient
	public static final HttpClient httpClient = HttpClients.createDefault();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 设置动态url
		String url = "https://music.taihe.com/songlist";
		// get的请求
		HttpGet httpGet = new HttpGet(url);
		// 确定是否有参数
		// 设置为人工访问
		httpGet.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		// 设置超时
		RequestConfig request = RequestConfig.custom().setConnectTimeout(5000)// 连接超时
				.setConnectionRequestTimeout(5000)// 请求超时
				.setSocketTimeout(5000).build();// Socket协议超时
		// 设置连接
		httpGet.setConfig(request);
		// 执行请求
		HttpResponse response = httpClient.execute(httpGet);
		System.out.println("版本信息"+response.getProtocolVersion());
		System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
		//获得httpentity对象
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			// 关闭HttpEntity是的流
//			EntityUtils.consume(entity);
			String html = EntityUtils.toString(entity);
			//实例文档对象，
			Document document = Jsoup.parse(html);
			System.out.println(document);
		}
		((Closeable) response).close();
	}

}
