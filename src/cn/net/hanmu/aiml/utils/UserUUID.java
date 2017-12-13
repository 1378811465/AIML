package cn.net.hanmu.aiml.utils;

import java.util.UUID;
/**
 * uuid生成类
 * @author 赵淞
 *
 */
public class UserUUID {
	/*
	 * 生成uuid
	 */
	public static String takeUUID(){
		//声明一个字符串来接收随机生成的uuid
		String uuid = UUID.randomUUID().toString().replace("-", "");
		//返回uuid值
	    return uuid;
		
	}

}
