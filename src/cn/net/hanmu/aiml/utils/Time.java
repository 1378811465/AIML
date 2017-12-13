package cn.net.hanmu.aiml.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	public static String getTime(){
		String time = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = df.format(new Date());
		return time;
	}
}
