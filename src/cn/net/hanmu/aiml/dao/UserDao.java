package cn.net.hanmu.aiml.dao;

import java.sql.SQLException;
import java.util.List;

import cn.net.hanmu.aiml.pojo.User;

public interface UserDao {
	public List<User> findAll(String sayname) throws ClassNotFoundException, SQLException;

}
