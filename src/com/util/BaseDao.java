package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * mysql操作工具类   封装了获取连接  释放资源  增删改操作   查询操作
 * @author Admin
 *
 */
public class BaseDao {
	static private String driver=null;
	static private String url=null;
	static private String user=null;
	static private String password=null;
	
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement st =null;
	
	static{
		init();
	}
	
	public static void init(){
		Properties param=new Properties();
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			param.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=param.getProperty("driver");
		url=param.getProperty("url");
		user=param.getProperty("user");
		password=param.getProperty("password");
		
	}
	
	public Connection getConnection(){
		
		// 1、加载驱动
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2、建立连接
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}
	/**
	 * 释放资源（注意顺序）
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/**
	 * 增删改操作  insert update  delete  
	 * @param sql
	 * @param param
	 * @return 受影响的行数  int
	 */
	public int executeUpdate(String sql,Object... param){
		int hs=0;
	
		
		
		try {
			st=getConnection().prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					st.setObject(i+1, param[i]);
				}
			}
			hs=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return hs;
	}
	
	
	/**
	 * 新增操作  insert 
	 * @param sql
	 * @param param
	 * @return 自增的主键  id
	 */
	public int executeInsertGetId(String sql,Object... param){
		int id=0;
		try {
			st=getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					st.setObject(i+1, param[i]);
				}
			}
			st.executeUpdate();
			rs=st.getGeneratedKeys();
			rs.next();
			id=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return id;
	}
	
	
	/**
	 * 新增语句 返回自增主键值
	 * @param sql
	 * @param param
	 * @return 受影响的行数  int
	 */
	public int executeInsert(String sql,Object... param){
		int hs=0;
	
		
		
		try {
			st=getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					st.setObject(i+1, param[i]);
				}
			}
			st.executeUpdate();
			 rs=st.getGeneratedKeys();
			if(rs.next()){
				hs=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return hs;
	}
	
	/**
	 * 查询操作 select
	 * @param sql
	 * @param param
	 * @return 结果集  resultSet
	 */
	public ResultSet executeQuery(String sql,Object... param){
		
		
	
		try {
			st=getConnection().prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					st.setObject(i+1, param[i]);
				}
			}
			rs=st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

}
