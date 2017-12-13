package cn.net.hanmu.aiml.service;

import java.sql.SQLException;
import java.util.List;

import cn.net.hanmu.aiml.pojo.User;

public interface UserService_ts {

	public List<User> tuiSong(String id,String user,String proble,String answer,String time) throws SQLException;
	public String fanHui() throws ClassNotFoundException, SQLException;
	public List<User> tuisong(String user_name) throws ClassNotFoundException, SQLException;
	public List<User> findSelect(String username) throws ClassNotFoundException, SQLException;
}
