/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong
 *	jsoup连接url
 */
public class JsoupConnectUrl {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建连接
		Connection connect = Jsoup.connect("https://www.bilibili.com/");
		// 请求网页，也可以使用POST请求
		Document document = connect.get();
		// 输出xml
		System.out.println(document);
	}

}
