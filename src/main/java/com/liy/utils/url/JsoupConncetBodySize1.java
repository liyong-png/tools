/**
 * 
 */
package com.liy.utils.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * @author liyong
 * @date 2021年2月9日
 * @time 下午2:46:45
 */
public class JsoupConncetBodySize1 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String url = "https://sdl108.yunpan.360.cn//share.php?method=Share.download&cqid=fb45629804a732f9273f76d694868868&dt=108.7d1a28092584592d6528aade144da5b4&e=1612857575.26267&fhash=e6a0254b206f0534da3f069ea242e1bf8b1047de&fname=%25E7%25BB%258F%25E5%2585%25B8%25E6%25AD%258C%25E6%259B%25B2%25E5%25A4%25A7%25E5%2585%25A8750%25E9%25A6%2596.zip&fsize=8409323198&nid=16033022852400213&st=9072783e0de97b9c1fa183dffc1337ef&xqid=32197259";
		// 设置超大文件超出时间 Integer.MAX_VALUE为设置的请求文件大小
		Response response = Jsoup.connect(url).timeout(10 * 60 * 1000).maxBodySize(Integer.MAX_VALUE).method(Method.GET)
				.ignoreContentType(true).execute();
		System.out.println("类型：" + response.contentType());
		if (response.statusCode() == 200) {
			// 响应转化成输出流
			BufferedInputStream InputStream = response.bodyStream();
			try {
				saveImage(InputStream, "D:\\Downloads\\1.zip");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 报存图片
	 * @param inputStream
	 * @param saveUrl 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("resource")
	private static void saveImage(BufferedInputStream in, String saveUrl) throws IOException, InterruptedException {
		byte[] buffer = new byte[1024];
		int len = 0;
		// 创建缓冲流
		FileOutputStream fileOutputStream = new FileOutputStream(new File(saveUrl));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 图片写入
		while ((len = in.read(buffer, 0, 1024)) != -1) {
			bufferedOutputStream.write(buffer, 0, len);
		}
		// 缓冲流释放关闭
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
}
