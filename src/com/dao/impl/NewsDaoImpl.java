package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.NewsDao;
import com.entity.News;
import com.util.BaseDao;
public class NewsDaoImpl extends BaseDao implements NewsDao {

	public List<News> selByLimit(int limit) {
		List<News> list=new ArrayList<News>();
		ResultSet rs=null;
		String sql="select * from easybuy_news order by createTime limit ?";
		rs=super.executeQuery(sql,limit);
		try {
			while(rs.next()){
				News news=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<News> selAll() {
		List<News> list=new ArrayList<News>();
		ResultSet rs=null;
		String sql="select * from easybuy_news order by createTime ";
		rs=super.executeQuery(sql);
		try {
			while(rs.next()){
				News news=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return list;
	}


	public int selTotalCount() {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_news ";
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
		return line;
	}

	public List<News> selCurrentPageNoAndLimit(int currentPageNo, int pageSize) {
		List<News> list=new ArrayList<News>();
		ResultSet rs=null;
		String sql="select * from easybuy_news order by createTime desc limit ?,?";
		rs=super.executeQuery(sql,(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				News news=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return list;
	}


	public List<News> selNewsById(int id) {
		List<News> listn=new ArrayList<News>();
		ResultSet rs=null;
		String sql="select * from easybuy_news where id=?";
		rs=super.executeQuery(sql,id);
		try {
			while(rs.next()){
			News news=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			listn.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return listn;
	}


	public int addNews(News news) {
		int line=0;
		String sql="insert into easybuy_news(title,content,createTime) values(?,?,?)";
		line=super.executeInsert(sql,news.getTitle(),news.getContent(),news.getCreateTime());
		// TODO Auto-generated method stub
		return line;
	}


	public int updateNews(News news) {
		int line=0;
		String sql="update easybuy_news set title=?,content=?,createTime=? where id=?";
		line=super.executeUpdate(sql,news.getTitle(),news.getContent(),news.getCreateTime(),news.getId());
		// TODO Auto-generated method stub
		return line;
	}

	public int deleteNews(int id) {
		int line=0;
		String sql="delete from easybuy_news where id=?";
		line=super.executeUpdate(sql,id);
		// TODO Auto-generated method stub
		return line;
	}


	public int selTotalCount(String title) {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_news where title like ?";
		rs=super.executeQuery(sql,"%"+title+"%");
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


	public List<News> selByCurrentPageNoAndLimitAndTitle(int currentPageNo, int pageSize,String title) {
		List<News> list=new ArrayList<News>();
		ResultSet rs=null;
		String sql="select * from easybuy_news where title like ? order by createTime desc limit ?,?";
		rs=super.executeQuery(sql,"%"+title+"%",(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				News news=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return list;
	}

	

}
