/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import url.BuilderUtils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong
 *
 */
public class JsoupConnertHeaderList {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建连接
		Connection connect = Jsoup.connect("https://www.bilibili.com/");
		BuilderUtils builder = new BuilderUtils();
		Map<String, String> header = new HashMap<String, String>();
		header.put("Host", "https://www.bilibili.com/");
		header.put("user-agent", builder.getUserAgentList().get(new Random().nextInt(builder.getUserAgentSize())));
		header.put("accept-encoding", builder.getAcceptEncoding());
		header.put("accept-language", builder.getAcceptLanguage());
		header.put("content-type", builder.getContentType());
		Connection headers = connect.headers(header);
		// 请求网页
		Document document = headers.get();
		System.out.println(document);
	}
}