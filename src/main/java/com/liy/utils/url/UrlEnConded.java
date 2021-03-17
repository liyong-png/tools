/**
 * 
 */
package com.liy.utils.url;

import java.net.URLEncoder;

/**
 * @author liyong
 *
 */
public class UrlEnConded {

	public static void main(String[] args) {
		String keyword = "金融"; // 需要转码的字段
		try {
			// 输入的编码为GBK
			String encode = URLEncoder.encode(keyword, "GBk");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
