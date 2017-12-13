package cn.net.hanmu.aiml.dao.imp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.sql.Connection;

import cn.net.hanmu.aiml.dao.UserDao;
import cn.net.hanmu.aiml.pojo.User;

public class UserDaoImp implements UserDao {

	
	public List<User> findAll(String sayname) throws ClassNotFoundException, SQLException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from lishi where name = '"+sayname+"'";
		System.out.println(sql);
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setData(rs.getString("data"));
			list.add(user);
		}
		return list;
	}
	public List<User> findAll_renwu(String sayname) throws ClassNotFoundException, SQLException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from lishirenwu where name = '"+sayname+"'";
		System.out.println(sql);
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setData(rs.getString("data"));
			list.add(user);
		}
		return list;
	}
}
