package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductCategoryDao;
import com.entity.News;
import com.entity.ProductCategory;
import com.util.BaseDao;

public class ProductCategoryDaoImpl extends BaseDao implements
		ProductCategoryDao {


	public List<ProductCategory> selByParentId(int parentId) {
		List<ProductCategory> list=new ArrayList<ProductCategory>();
		ResultSet rs=null;
		String sql="select * from easybuy_product_category  where  parentId=?";
		rs=super.executeQuery(sql,parentId);
		try {
			while(rs.next()){
				ProductCategory productCategory=new ProductCategory(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				list.add(productCategory);
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
	
	
	
	//两表连接查询商品分类信息
	
	public int selTotalCount() {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_product_category";
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


	public List<ProductCategory> sellCurrentPageNoAndLimit(int currentPageNo,int pageSize) {
		List<ProductCategory> pro=new ArrayList<ProductCategory>();
		ResultSet rs=null;
		String sql="select a.*,IFNULL(b.`name`,'无') as parentName from easybuy_product_category AS a left JOIN easybuy_product_category as b ON a.parentId=b.id limit ?,?";
		rs=super.executeQuery(sql,(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				ProductCategory proc=new ProductCategory(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				pro.add(proc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return pro;
	}



	public int add(String name, int parentid,int type) {
		int hs=0;
		String sql="insert into easybuy_product_category(name,parentid,type) value(?,?,?)";
		hs=this.executeUpdate(sql, name,parentid,type);
		return hs;
	}




	public List<ProductCategory> selltype(int type) {
		List<ProductCategory> procate=new ArrayList<ProductCategory>();
		ResultSet rs=null;
		String sql="select * from easybuy_product_category where type=?";
		rs=this.executeQuery(sql, type);
		try {
			while(rs.next()){
				ProductCategory proc=new ProductCategory(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				procate.add(proc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return procate;
	}



	public int deletef(int id) {
		// TODO Auto-generated method stub
				String sql="delete from easybuy_product_category where id=?";
				int sf=this.executeUpdate(sql, id);
				return sf;
	}
	
}
