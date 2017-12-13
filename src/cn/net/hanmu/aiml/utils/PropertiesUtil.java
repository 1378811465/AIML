package cn.net.hanmu.aiml.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
	
	/**
	 * 固定文件读取配置
	 * 
	 * @param key 键名
	 * @author Augus 2017-07-17
	 * @return 对应键值
	 */
	public static String getString(String key) {

		Properties tmpProperties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = PropertiesUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					inputStream));
			tmpProperties.load(bf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
					inputStream = null;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		Object obj;
		return key == null || "".equals(key) ? "" : ((obj = tmpProperties
				.get(key)) == null ? "" : (String) obj);
	}
	
	/**
	 * 指定文件读取配置
	 * 
	 * @param key 键名
	 * @param propertiesFile 配置文件
	 * @author Augus 2017-07-17
	 * @return 对应键值
	 */
	public static String getString(String key, String propertiesFile) {

		Properties tmpProperties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = PropertiesUtil.class.getClassLoader()
					.getResourceAsStream(propertiesFile);
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					inputStream));
			tmpProperties.load(bf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
					inputStream = null;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		Object obj;
		return key == null || "".equals(key) ? "" : ((obj = tmpProperties
				.get(key)) == null ? "" : (String) obj);
	}
}
