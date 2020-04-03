package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.User;
import com.util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {


	public User selByLoginNameAndPassword(String loginName, String password) {
		User user=null;
		String sql="select * from easybuy_user where loginName=? and password=?";
		ResultSet rs=null;
		rs=super.executeQuery(sql,loginName,password);
		try {
			while(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return user;
	}


	public int addByUser(User user) {
		int line=0;
		String sql="insert into easybuy_user (loginName,userName,password,sex,identityCode,email,mobile,type) value(?,?,?,?,?,?,?,?)";
		line=super.executeUpdate(sql,user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType());
		// TODO Auto-generated method stub
		return line;
	}


	public int selUserCountByLoginName(String loginName) {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_user where loginName=?";
		rs=super.executeQuery(sql,loginName);
		try {
			while(rs.next()){
				line=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return line;
	}


	public int selTotalCount() {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_user";
		rs=super.executeQuery(sql);
		try {
			while(rs.next()){
				line=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return line;
	}


	public List<User> selByCurrentPageNoAndPageSize(int currentPageNo,
			int pageSize) {
		List<User> list=new ArrayList<User>();
		ResultSet rs=null;
		String sql="select * from easybuy_user limit ?,?";
		rs=super.executeQuery(sql,(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}


	public User selById(int id) {
		User user=null;
		String sql="select * from easybuy_user where id=?";
		ResultSet rs=null;
		rs=super.executeQuery(sql,id);
		try {
			while(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return user;
	}


	public int updateUserByUser(User user) {
		int line=0;
		String sql="update easybuy_user  set loginName=?,userName=?,identityCode=?,email=?,mobile=?,type=? where id=?";
		line=super.executeUpdate(sql,user.getLoginName(),user.getUserName(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType(),user.getId());
		return line;
	}

	
	public int deleteById(int id) {
		int line=0;
		String sql="delete from easybuy_user where id=?";
		line=super.executeUpdate(sql,id);
		// TODO Auto-generated method stub
		return line;
	}


	public int selTotalCountAndLoginName(String loginName) {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_user where loginName like ?";
		rs=super.executeQuery(sql,"%"+loginName+"%");
		try {
			while(rs.next()){
				line=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return line;
	}


	public List<User> selByCurrentPageNoAndPageSizeAndLoginName(
			int currentPageNo, int pageSize, String loginName) {
		List<User> list=new ArrayList<User>();
		ResultSet rs=null;
		String sql="select * from easybuy_user where loginName like ?  limit ?,?";
		rs=super.executeQuery(sql,"%"+loginName+"%",(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

}
