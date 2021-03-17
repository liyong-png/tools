/**
 * 
 */
package com.liy.utils.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * @author liyong
 * @date 2021年2月8日
 * @time 下午6:15:37
 */
public class JsoupConncetInputStream {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201312%2F31%2F111859myvyiivetyftfz2n.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1615372863&t=177d24403ccf79aff7a6e3003ff9aae2";
		Connection connect = Jsoup.connect(imageUrl);
		// ignoreContentType 设置为true将强制进行解析尝试，而不管内容类型如何。
		Response response = connect.method(Method.GET).ignoreContentType(true).execute();
		System.out.println("图片类型：" + response.contentType());
		// 响应转化成输出流
		BufferedInputStream InputStream = response.bodyStream();
		try {
			saveImage(InputStream, "D:\\Downloads\\1.jpeg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
