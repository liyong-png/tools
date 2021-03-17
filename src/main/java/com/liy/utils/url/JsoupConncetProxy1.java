/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * @author liyong
 * @date 2021年2月8日
 * @time 下午5:16:04
 */
public class JsoupConncetProxy1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 第一种方式设置代码
		// 此类表示代理设置，通常是类型（http，socks）和套接字地址
		// 详见： https://www.matools.com/file/manual/jdk_api_1.8_google/java/net/Proxy.html
		// InetSocketAddress 的父类SocketAddress是个抽象类
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("171.221.239.11",808));
		// 创建连接
		Connection connect = Jsoup.connect("https://www.bilibili.com/").proxy(proxy);
		Response response = connect.method(Method.GET).timeout(10*1000).execute();
		// 获取响应状态码
		int statusCode = response.statusCode();
		System.out.println(statusCode);
	}

}
