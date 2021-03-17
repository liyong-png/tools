/**
 * 
 */
package com.liy.utils.url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author liyong
 *
 */
public class JsoupConnertHeaderHashMap {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建连接
//		Connection connect = Jsoup.connect("https://www.bilibili.com/");
		Connection connect = Jsoup.connect("https://www.bilibili.com/video/BV115411n7QH?spm_id_from=333.851.b_7265636f6d6d656e64.1");
		Map<String, String> header = new HashMap<String, String>();
		header.put("Host", "https://www.bilibili.com/");
		header.put("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36");
		header.put("accept-encoding", "gzip, deflate, br");
		header.put("accept-language", "zh-CN,zh;q=0.9");
		header.put("content-type", "text/plain;charset=UTF-8");
		Connection headers = connect.headers(header);
		// 请求网页
		Document document = headers.get();
		System.out.println(document);
	}

}
