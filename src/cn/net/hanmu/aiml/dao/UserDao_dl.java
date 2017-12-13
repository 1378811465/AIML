package cn.net.hanmu.aiml.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

import cn.net.hanmu.aiml.pojo.User;

public class UserDao_dl {

	public List<User> findAll(String username) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接对象(localhost)代表本机的意思，也可以填IP
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "root");
		//创建sql语句
		String sql = "select * from student where name = '"+username+"'";
		//通过prepareStatement方法创建PreparedStatement将sql语句发送到数据库中
		PreparedStatement statement =  (PreparedStatement) conn.prepareStatement(sql);
		//创建结果集(接受查询的结果)
		ResultSet rs = statement.executeQuery();
		//创建Arralist集合
		List<User> userList = new ArrayList<User>();
		//遍历
		while(rs.next()){
			User user = new User();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setImg(rs.getString("img"));
			user.setQuanxian(rs.getString("quanxian"));
			userList.add(user);
		}
		//返回List集合的对象
		return userList;
		
	}
	public List<User> addUser(User user) throws SQLException, ClassNotFoundException{
		//首先加载JDBC-ODBC桥的驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接对象(localhost)代表本机的意思，也可以填IP
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "root");
		//创建sql语句
		String sql = "insert into student(id,name,password,quanxian,img) values('"+user.getId()+"','"+user.getName()+"','"+user.getPassword()+"','"+user.getQuanxian()+"','"+user.getImg()+"')";
		//创建statement实例
		Statement statement = (Statement) conn.createStatement();
		//将sql语句发送到数据库处理，返回多个数值
		statement.execute(sql);
		//关闭数据库操作对象，释放statement对象的资源
		statement.close();
		//关闭数据库连接，释放数据库连接的资源
		conn.close();
		//返回空值
		return null;
	}

	public String takeUUID(){
		//声明一个字符串来接受随机生成的uuid
		String uuid = UUID.randomUUID().toString().replace("-", "");
		//返回uuid
		return uuid;
	}
	public List<User> findById(String username) throws ClassNotFoundException, SQLException {
		//註冊驅動器
		Class.forName("com.mysql.jdbc.Driver");
		//創建連接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		//sql查询语句
		String sql = "select * from student where name = '"+username+"'";
		//创建preparedStatement实例
		PreparedStatement pstatement = (PreparedStatement) conn.prepareStatement(sql);
		//创建结果集
		ResultSet rs = pstatement.executeQuery();
		//创建List集合
		List<User> list = new ArrayList<User>();
		//遍历结果集
		while(rs.next()){
			User user = new User();
			user.setId(takeUUID());
			user.setName(rs.getString("name"));
			list.add(user);
		}
		rs.close();
		pstatement.close();
		conn.close();
		return list;
}
}
