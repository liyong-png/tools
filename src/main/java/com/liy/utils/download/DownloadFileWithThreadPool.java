package com.liy.utils.download;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadFileWithThreadPool {

	/**
	 * 
	 * @param urlLocation 目标路径
	 * @param filePath    本地路径
	 * @param poolLength  线程数量
	 * @throws IOException
	 */
	public void getFileWithThreadPool(String urlLocation, String filePath, int poolLength) throws IOException {
		// 对本地文件判读
		String filePathwjj;
		if (filePath.contains("/")) {
			filePathwjj = filePath.substring(0, filePath.lastIndexOf("/"));
		} else {
			filePathwjj = filePath.substring(0, filePath.lastIndexOf("\\"));
		}
		File file = new File(filePathwjj);
		if (!file.exists()) {
			file.mkdirs(); // 创建多及目录文件夹(包括但不限一级目录)
		}
		// 创建线程池对象
		ExecutorService threadPool = Executors.newCachedThreadPool();
		long len = getContentLength(urlLocation);
		System.out.println(len);
		for (int i = 0; i < poolLength; i++) {
			long start = i * len / poolLength;
			long end = (i + 1) * len / poolLength - 1;
			if (i == poolLength - 1) {
				end = len;
			}
			System.out.println(start + "---------------" + end);
			DownloadWithRange download = new DownloadWithRange(urlLocation, filePath, start, end);
			threadPool.execute(download);
		}
		// 关闭线程池
		threadPool.shutdown();
	}

	public static long getContentLength(String urlLocation) throws IOException {
		URL url = null;
		if (urlLocation != null) {
			url = new URL(urlLocation);
		}
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(5000);
		conn.setRequestMethod("GET");
		long len = conn.getContentLength();

		return len;
	}

}
