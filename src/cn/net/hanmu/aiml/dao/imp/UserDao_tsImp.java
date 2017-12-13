package cn.net.hanmu.aiml.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import cn.net.hanmu.aiml.dao.UserDao_ts;
import cn.net.hanmu.aiml.pojo.User;

public class UserDao_tsImp implements UserDao_ts{

	public List<User> tuiSong(String id,String user,String problem,String answer,String time) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="insert into  historic (id,user,problem,answer,time) values ('"+id+"','"+user+"','"+problem+"','"+answer+"','"+time+"')";
	
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
		//返回空值
		return null;
	}
	public String findAll() throws ClassNotFoundException, SQLException {	
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select problem,count(*) as count from historic group by problem order by count desc limit 1";
		System.out.println(sql);
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		
		//创建结果集
		ResultSet rs = statement.executeQuery();
		String fanhui = null;
		User user = new User();
		rs.next();
		user.setName(rs.getString("problem"));
		fanhui = user.getName();
		System.out.println(fanhui);
		return fanhui;
	}

	public List<User> findTuiSong(String user_name) throws ClassNotFoundException, SQLException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select problem,count(*) as count from historic where user = '"+user_name+"' group by problem order by count desc limit 3";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setProblem(rs.getString("problem"));
			list.add(user);
		}
		return list;
	}
	public List<User> findSelect(String username) throws ClassNotFoundException, SQLException{
				//注册驱动器
				Class.forName("com.mysql.jdbc.Driver"); 
				//创建数据库连接
				Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
				//创建sql
				String sql = "select * from historic where user = '"+username+"' order by time desc";
				System.out.println(sql);
				//创建statement实例
				PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
				//创建结果集
				ResultSet rs = statement.executeQuery();
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getString("id"));
					user.setUsername(rs.getString("user"));
					user.setTime(rs.getString("time"));
					user.setProblem(rs.getString("problem"));
					user.setAnswer(rs.getString("answer"));
					list.add(user);
				}
				return list;
	}
	public List<User> selectDy() throws ClassNotFoundException, SQLException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建查询所有可订阅模板sql
		String sql = "select * from dingyue";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("id"));
			user.setName(rs.getString("name"));
			list.add(user);
		}
		return list;
	}
	public List<User> findAllDy(String user_dy) throws ClassNotFoundException, SQLException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from userdingyue where user = '"+user_dy+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("id"));
			user.setName(rs.getString("name"));
			list.add(user);
		}
		return list;
	}
	public List<User> dingyue(String id,String user,String name,String data) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="insert into  userdingyue (id,user,name,data) values ('"+id+"','"+user+"','"+name+"','"+data+"')";
	
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
		//返回空值
		return null;
	}
	public List<User> select_Dy(String user_dy,String name) throws SQLException, ClassNotFoundException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from userdingyue where user = '"+user_dy+"' and name = '"+name+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("id"));
			user.setName(rs.getString("name"));
			list.add(user);
		}
		return list;
	}public List<User> sl_Dy(String name) throws SQLException, ClassNotFoundException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建查询可订阅内容的sql语句
		String sql = "select * from dingyue where name = '"+name+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		System.out.println(statement);
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
	public List<User> qxDingYue(String id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册驱动器
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//创建数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		//根据用户名和订阅模板名的条件创建取消订阅的sql语句
		String sql ="delete from userdingyue where id='"+id+"'";
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
		//返回空值
		return null;
	}
	public List<User> ts_Dy(String user_dy) throws SQLException, ClassNotFoundException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//根据用户创建用户订阅的sql语句
		String sql = "select * from userdingyue where user = '"+user_dy+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();

		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("name"));
			user.setData(rs.getString("data"));
			user.setId(rs.getString("id"));
			list.add(user);
		}
		return list;
	}
	public List<User> findUser() throws SQLException, ClassNotFoundException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建查询用户的sql语句
		String sql = "select * from student where  quanxian = '普通用户' or quanxian = '高级用户'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setQuanxian(rs.getString("quanxian"));
			list.add(user);
		}
		return list;
		
	}

	public void updateQuanXian(String id,String quanxian) throws ClassNotFoundException, SQLException{
		//首先加载JDBC-ODBC桥的驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接对象(localhost)代表本机的意思，也可以填IP
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		if(quanxian.equals("普通用户")){
			String sql = "update student set quanxian= '高级用户' where id='"+id+"'";
			//创建statement实例
			Statement statement = (Statement) conn.createStatement();
			//将sql语句发送到数据库处理，返回单个数值
			statement.execute(sql);
			//关闭数据库操作对象，释放statement对象的资源
			statement.close();
			//关闭数据库连接，释放数据库连接的资源
			conn.close();
		}else{
			//创建权限修改语句sql语句
			String sql = "update student set quanxian= '普通用户' where id='"+id+"'";
			//创建statement实例
			Statement statement = (Statement) conn.createStatement();
			//将sql语句发送到数据库处理，返回单个数值
			statement.execute(sql);
			//关闭数据库操作对象，释放statement对象的资源
			statement.close();
			//关闭数据库连接，释放数据库连接的资源
			conn.close();
		}
		
	}
	public List<User> findUser_quanxian(String name) throws SQLException, ClassNotFoundException{
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from student where name = '"+name+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setQuanxian(rs.getString("quanxian"));
			list.add(user);
		}
		return list;
		
	}
	public List<User> getQuanxian(String id) throws SQLException, ClassNotFoundException {
		//注册驱动器
				Class.forName("com.mysql.jdbc.Driver");
				//创建数据库连接
				Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
				//创建sql
				String sql = "select * from student where id = '"+id+"'";
				System.out.println(sql);
				//创建statement实例
				PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
				//创建结果集
				ResultSet rs = statement.executeQuery();
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setQuanxian(rs.getString("quanxian"));
					list.add(user);
				}
				return list;
	}
	public List<User> listDingYue() throws ClassNotFoundException, SQLException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from userdingyue";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(rs.getString("user"));
			user.setName(rs.getString("name"));
			user.setData(rs.getString("data"));
			list.add(user);
		}
		return list;
	}
	public List<User> my_dingyue(String username) throws ClassNotFoundException, SQLException {
		//注册驱动器
				Class.forName("com.mysql.jdbc.Driver");
				//创建数据库连接
				Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
				//创建sql
				String sql = "select * from userdingyue where user = '"+username+"'";
				//创建statement实例
				PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
				//创建结果集
				ResultSet rs = statement.executeQuery();
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getString("id"));
					user.setUsername(rs.getString("user"));
					user.setName(rs.getString("name"));
					user.setData(rs.getString("data"));
					list.add(user);
				}
				return list;
	}
	public void updateApplyOne(String id, String username) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="update applyFor set state='2' where id = '"+id+"'";
		String sql2 ="update student set quanxian='高级用户' where name = '"+username+"'";
		Statement statement = conn.createStatement();
		statement.execute(sql);
		statement.execute(sql2);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
	}
	public void updateApplyTwo(String id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="update applyFor set state='3' where id = '"+id+"'";
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
	}
	public List<User> getUserName(String id) throws SQLException, ClassNotFoundException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from applyFor where id = '"+id+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		System.out.println("22"+statement);
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setUsername(rs.getString("username"));
			list.add(user);
		}
		return list;
	}
	public List<User> listApply() throws SQLException, ClassNotFoundException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from applyFor";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setReason(rs.getString("reason"));
			user.setState(rs.getString("state"));
			list.add(user);
		}
		return list;
	}
	public List<User> listApply_name(String username) throws SQLException, ClassNotFoundException {
		//注册驱动器
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&autoReconnect=true&characterEncoding=utf-8","root","root");
		//创建sql
		String sql = "select * from applyFor where username = '"+username+"'";
		//创建statement实例
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = statement.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setReason(rs.getString("reason"));
			user.setState(rs.getString("state"));
			list.add(user);
		}
		return list;
	}
	public void insertApplyFor(String username, String uuid) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="insert into applyFor(id,username,reason,state) values('"+uuid+"','"+username+"','非常希望可以体验你们的历史人物功能！','1')";
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
	}
	public List<User> listdingyue_muban() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql = "select name,count(*) as count from userdingyue  group by name order by count desc limit 5";
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=statement.executeQuery();
		System.out.println(statement);
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User us = new User();
			us.setData(rs.getString("name"));
			us.setCount(rs.getString("count"));
			list.add(us);
		}

		return list;
	}
	public void xiugaiPassword(String user, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		String sql ="update student set password = '"+password+"' where name = '"+user+"'";
		Statement statement = conn.createStatement();
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
	}

	
}
