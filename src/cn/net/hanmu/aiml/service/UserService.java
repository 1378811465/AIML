package cn.net.hanmu.aiml.service;

import java.sql.SQLException;
import java.util.List;

import cn.net.hanmu.aiml.pojo.User;

public interface UserService {
	public List<User> findAll(String sayname) throws ClassNotFoundException, SQLException;
}
