package com.liy.utils.download;

import java.io.IOException;
import java.util.Date;

import url.UrlProperties;

public class test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
    	UrlProperties urlProperties = new UrlProperties();
    	// 目标路径
    	String url = (String) urlProperties.getUrlProperties("url");
    	// 本地路径
    	String bdurl = (String) urlProperties.getUrlProperties("bdUrl");
    	// 拼接后面的名称
    	if(url.contains("\\")) {
    		url.replace("\\", "/");
    	}
    	String substring = url.substring(url.lastIndexOf("/"));
    	String bdUrl = bdurl + substring;
        Date startDate = new Date();
        DownloadFileWithThreadPool pool = new DownloadFileWithThreadPool();
        try {
            pool.getFileWithThreadPool(url, bdUrl, 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("用时(毫秒)：" + (new Date().getTime() - startDate.getTime()));
    }

}
