package cn.net.hanmu.aiml.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.net.hanmu.aiml.dao.imp.UserDao_tsImp;
import cn.net.hanmu.aiml.pojo.User;
import cn.net.hanmu.aiml.service.UserService_ts;

public class UserService_tsImp implements UserService_ts {

	public List<User> tuiSong(String id,String user,String problem,String answer,String time) throws SQLException {
		UserDao_tsImp ts = new UserDao_tsImp();
		List<User> list = ts.tuiSong(id,user,problem,answer,time);
		return list;
	}
	public String fanHui() throws ClassNotFoundException, SQLException{
		UserDao_tsImp ts = new UserDao_tsImp();
		String fanhui;
		fanhui = ts.findAll();
		return fanhui;
	}
	public List<User> tuisong(String user_name) throws ClassNotFoundException, SQLException {
		UserDao_tsImp ts = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = ts.findTuiSong(user_name);
		return list;
	}
	public List<User> findSelect(String username) throws ClassNotFoundException, SQLException{
		UserDao_tsImp ts = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = ts.findSelect(username); 
		return list;
	}
	

}
