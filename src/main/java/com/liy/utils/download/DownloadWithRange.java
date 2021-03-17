package com.liy.utils.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class DownloadWithRange implements Runnable {
	private String urlLocation;

	private String filePath;

	private long start;

	private long end;
	
	DownloadWithRange(String urlLocation, String filePath, long start, long end) {
		this.urlLocation = urlLocation;
		this.filePath = filePath;
		this.start = start;
		this.end = end;
	}

	public void run() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
			String dateFormat = simpleDateFormat.format(new Date());
			System.out.println("开始时间[" + dateFormat);
			try {
				Thread.sleep(2000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			HttpURLConnection conn = getHttp();
			// 设定传送的内容类型是可序列化的java对象
			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
			File file = new File(filePath);
			RandomAccessFile out = null;
			if (file != null) {
				// 参数：
				// "r" : ** 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
				// "rw": 打开以便读取和写入。
				// "rws": 打开以便读取和写入。相对于 "rw"，"rws" 还要求对“文件的内容”或“元数据”的每个更新都同步写入到基础存储设备。
				// "rwd" : 打开以便读取和写入，相对于 "rw"，"rwd" 还要求对“文件的内容”的每个更新都同步写入到基础存储设备。
				out = new RandomAccessFile(file, "rw");
			}
			// 将文件指针定位到pos位置
			out.seek(start);
			InputStream in = conn.getInputStream();
			byte[] b = new byte[1024];
			int len = 0;

			while ((len = in.read(b)) >= 0) {
				out.write(b, 0, len);
			}

			String dateFormats = simpleDateFormat.format(new Date());
			System.out.println("结束时间[" + dateFormats);
			in.close();
			out.close();
			System.out.println("下载完成...");
		} catch (Exception e) {
			e.getMessage();
		} 

	}

	public HttpURLConnection getHttp() throws IOException {
		URL url = null;
		if (urlLocation != null) {
			url = new URL(urlLocation);
		}
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(5000);
		conn.setRequestMethod("GET");

		return conn;
	}

}