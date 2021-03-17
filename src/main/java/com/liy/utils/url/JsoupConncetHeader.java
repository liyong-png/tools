/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong Jsoup连接请求头
 */
public class JsoupConncetHeader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 连接b站
		Connection connect = Jsoup.connect("https://www.bilibili.com/");
		// 设置请求头
		Connection header = connect.header("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36");
		Document document = header.get();
		System.out.println(document);
	}

}
