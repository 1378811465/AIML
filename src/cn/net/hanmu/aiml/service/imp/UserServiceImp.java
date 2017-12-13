package cn.net.hanmu.aiml.service.imp;

import java.sql.SQLException;
import java.util.List;

import cn.net.hanmu.aiml.dao.imp.UserDaoImp;
import cn.net.hanmu.aiml.pojo.User;
import cn.net.hanmu.aiml.service.UserService;

public class UserServiceImp implements UserService {

	public List<User> findAll(String sayname) throws ClassNotFoundException, SQLException {
		UserDaoImp udi = new UserDaoImp();
		List<User> list = udi.findAll(sayname);
		return list;
	}

}
