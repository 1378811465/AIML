package cn.net.hanmu.aiml.utils;

import java.util.UUID;
/**
 * uuid������
 * @author ����
 *
 */
public class UserUUID {
	/*
	 * ����uuid
	 */
	public static String takeUUID(){
		//����һ���ַ���������������ɵ�uuid
		String uuid = UUID.randomUUID().toString().replace("-", "");
		//����uuidֵ
	    return uuid;
		
	}

}
