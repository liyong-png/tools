package com.liy.utils.httpClient;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawPictureVec {

	private static HttpClient httpClient = HttpClients.custom().build(); 

	public static void main(String[] args) throws ParseException, IOException {
		// vecteezy图库
		String url = "https://www.vecteezy.com/free-vector/macbook";
		HttpEntity httpEntity = getEntityByHttpGetMethod(url);
		// 获取所有图片链接
		String html = EntityUtils.toString(httpEntity);
		// Jsoup解析html
		Elements elements = Jsoup.parse(html).select("#main > ul > li > a > img");
		for (Element ele : elements) {
			String picUrl = ele.attr("data-lazy-src");
			saveImge(picUrl, "D:/pic/" + picUrl.split("/")[10]);
		}
	}

	/**
	 * 保存图片
	 * @param picUrl
	 * @param string
	 * @throws IOException 
	 */
	private static void saveImge(String picUrl, String string) throws IOException {
		File file = new File(picUrl);
//		if(file.exists()) {
//			file.delete();
//		}
		// 缓存流
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));
		try {
			HttpEntity httpEntity = getEntityByHttpGetMethod(picUrl);
			// 以字节的方式写入
			byte[] bs = EntityUtils.toByteArray(httpEntity);
			bw.write(bs);
			System.out.println("图片下载成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}

	/**
	 * 根据某个url获取请求内容
	 * @param url
	 * @return
	 */
	private static HttpEntity getEntityByHttpGetMethod(String url) {
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity httpEntity = response.getEntity();
		return httpEntity;
	}

}
