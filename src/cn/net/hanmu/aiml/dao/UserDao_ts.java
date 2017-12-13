package cn.net.hanmu.aiml.dao;

import java.sql.SQLException;
import java.util.List;

import cn.net.hanmu.aiml.pojo.User;

public interface UserDao_ts {

	public List<User> tuiSong(String id,String user,String proble,String answer,String time) throws SQLException;
}
