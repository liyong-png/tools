/**
 * 
 */
package com.liy.utils.httpClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;

/**
 * @author liyong
 * @date 2021年2月9日
 * @time 下午3:50:37
 */
public class HttpGitInit {

	/**
	 * 创建请求方法实例
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
		String url = "https://www.bilibili.com/";
		// 第一种方式
		URI uri = new URI(url);
		HttpGet getMethod = new HttpGet();
		getMethod.setURI(uri);
		System.out.println(getMethod);
		//第二种
		HttpGet httpGetUri = new HttpGet(uri);
		System.out.println(httpGetUri);
		//第三种
		HttpGet httpGetUrl = new HttpGet(url);
		System.out.println(httpGetUrl);
		
	}

}
