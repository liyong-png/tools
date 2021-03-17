/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong
 *	jsoup连接url
 */
public class JsoupConnectUrl2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建连接
		Connection connect = Jsoup.connect("https://www.bilibili.com/");
		// 获取响应
		Response response = connect.method(Method.GET).execute();
		// 获取请求的url
		URL url = response.url();
		System.out.println("获取请求的url：" + url);
		// 获取状态响应码
		int statusCode = response.statusCode();
		System.out.println("获取状态响应码：" + statusCode);
		// 获取响应数据类型
		String contentType = response.contentType();
		System.out.println("获取相应数据类型：" + contentType);
		// 响应信息
		String statusMessage = response.statusMessage();
		System.out.println("响应信息：" + statusMessage);
		// 判断状态响应码等于200
		if ( 200 == statusCode ) {
			// 通过这种方式可以获取相应的xml
			String html = new String(response.bodyAsBytes(),"utf-8");
//			System.out.println("html:" + html);
			// 将响应的主体解析为文档。
			Document document = response.parse();
			System.out.println("document:" + document);
		}
	}

}
