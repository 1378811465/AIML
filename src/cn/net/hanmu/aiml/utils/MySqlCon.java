package cn.net.hanmu.aiml.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlCon {

	public static final String url = "jdbc:mysql://localhost:3306/barbershop";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root"; 
	
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		try {
			// 加载驱动
			Class.forName(name);
			// 获取连接
			Connection con = DriverManager.getConnection(url,user,password);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 关闭连接
	 * @param con
	 */
	public static void  close(ResultSet res,Connection con,PreparedStatement pre){
		try {
			if(res != null){
				res.close();
			}
			if(pre != null){
				pre.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
