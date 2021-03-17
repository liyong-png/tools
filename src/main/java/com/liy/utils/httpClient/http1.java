package com.liy.utils.httpClient;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class http1 {

	/**
	 * HttpClient的重要功能是执行HTTP请求方法，获取响应资源。
	 * 在执行具体的请求方法之前，需要实例化HttpClient。
	 * 第一种方式已经不再建议使用。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		HttpClient httpClient1 = new DefaultHttpClient();
		HttpClient httpClient2 = HttpClients.custom().build();
		HttpClient httpClient3 = HttpClientBuilder.create().build();
		CloseableHttpClient httpClient4 = HttpClients.createDefault();
		HttpClient httpClient5 = HttpClients.createSystem();
		HttpClient httpClient6 = HttpClients.createMinimal();
	}

}
