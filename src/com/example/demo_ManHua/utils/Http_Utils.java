package com.example.demo_ManHua.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 处理网页请求的类
 * 
 * @author X-man
 * @date 2016-11-3
 */
public class Http_Utils {
	public static String getstr(String url) {
		try {
			// 获得HttpConnection对象
			URL url2 = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
		
			// 设置时间
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			// 判断是否响应成功
			if (conn.getResponseCode() == 200) {
				// 获得输入流
				InputStream inputStream = conn.getInputStream();
				// 读取输入流中的信息
				byte[] by = new byte[1024];
				int len;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				while ((len = inputStream.read(by)) != -1) {
					baos.write(by, 0, len);
				}
				return baos.toString();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
