package com.weibo.zel.utils.sina;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadSpiderConfig {
	private static Properties config = null;
	static {
		InputStream in = ReadSpiderConfig.class.getClassLoader()
				.getResourceAsStream("crawl_config.properties");
		config = new Properties();
		try {
			config.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("No AreaPhone.properties defined error");
		}
	}

	// 根据key读取value
	public static String getValue(String key) {
		// Properties props = new Properties();
		try {
			String value = config.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ConfigInfoError" + e.toString());
			return null;
		}
	}

	public static void main(String args[]) {
		System.out.println(getValue("datasource.url"));
	}
}
