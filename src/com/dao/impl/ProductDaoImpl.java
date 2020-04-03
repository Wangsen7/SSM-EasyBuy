package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.entity.Product;
import com.util.BaseDao;

public class ProductDaoImpl extends BaseDao implements ProductDao {


	public List<Product> selByCategoryLevel1IdAndLimit(int categoryLevel1Id,int limit) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where  categoryLevel1Id=? order by id desc limit ?";
		rs=super.executeQuery(sql,categoryLevel1Id,limit);
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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


	public List<Product> selByCategoryLevel1IdOrCategoryLevel2IdOrCategoryLevel3Id(
			int CategoryLevel1Id) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where  categoryLevel1Id=? or categoryLevel2Id=? or categoryLevel3Id=? order by id desc ";
		rs=super.executeQuery(sql,CategoryLevel1Id,CategoryLevel1Id,CategoryLevel1Id);
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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

	public Product selByid(int id) {
		Product product=null;
		ResultSet rs=null;
		String sql="select * from easybuy_product  where  id=?";
		rs=super.executeQuery(sql,id);
		try {
			if(rs.next()){
				product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		// TODO Auto-generated method stub
		return product;
	}


	public List<Product> selByName(String name) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where name like ?";
		rs=super.executeQuery(sql,"%"+name+"%");
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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


	public int selTotalCount(int CategoryLevel1Id) {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_product where  categoryLevel1Id=? or categoryLevel2Id=? or categoryLevel3Id=? order by id desc";
		rs=super.executeQuery(sql,CategoryLevel1Id,CategoryLevel1Id,CategoryLevel1Id);
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


	public List<Product> selByCurrentPageNoAndLimit(int currentPageNo,
			int pageSize,int CategoryLevel1Id) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where  categoryLevel1Id=? or categoryLevel2Id=? or categoryLevel3Id=? order by id desc limit ?,?";
		rs=super.executeQuery(sql,CategoryLevel1Id,CategoryLevel1Id,CategoryLevel1Id,(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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


	public int selTotalCountByName(String name) {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_product where name like ? order by id desc";
		rs=super.executeQuery(sql,"%"+name+"%");
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


	public List<Product> selByCurrentPageNoAndLimitAndName(int currentPageNo,
			int pageSize, String name) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where name like ? limit ?,?";
		rs=super.executeQuery(sql,"%"+name+"%",(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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
/**
 * 展示商品信息
 */

	public int selTotalCount() {
		int line=0;
		ResultSet rs=null;
		String sql="select count(1) from easybuy_product where isDelete=0";
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


	public List<Product> selbuypage(int currentPageNo, int pageSize) {
		List<Product> list=new ArrayList<Product>();
		ResultSet rs=null;
		String sql="select * from easybuy_product where isDelete=0 limit ?,?";
		rs=super.executeQuery(sql,(currentPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				list.add(product);
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


	public int deleteSp(int id) {
		// TODO Auto-generated method stub
		String sql="update easybuy_product set isDelete=1 where id=?";
		int hs=this.executeUpdate(sql, id);
		return hs;
	}


	public int listShopping(Product product) {
		String sql="insert easybuy_product(name,description,price,stock,"+
				"categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete)"+
				"values(?,?,?,?,?,?,?,?,?);";
				int sf=this.executeInsert(sql,product.getName(),product.getDescription(),product.getPrice(),product.getStock(),
						product.getCategoryLevel1Id(),product.getCategoryLevel2Id(),product.getCategoryLevel3Id(),product.getFileName(),product.getIsDelete());
				
				return sf;
	}


	public int setShopping(Product product) {
		// TODO Auto-generated method stub
		String sql="update easybuy_product set name=?,description=?,price=?,stock=?,"+
		"categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,"+
				"fileName=?,isDelete=? where id=?";
		int sf=this.executeInsert(sql,product.getName(),product.getDescription(),product.getPrice(),product.getStock(),
				product.getCategoryLevel1Id(),product.getCategoryLevel2Id(),product.getCategoryLevel3Id(),product.getFileName(),
				product.getIsDelete(),product.getId());
		return sf;
	}
	

	public int tdindan(int userid, String loginName, String userAddress,
			float cost, String serialNumber) {
		// TODO Auto-generated method stub
		String sql="insert easybuy_order(userId,loginName,userAddress,createTime,cost,serialNumber)values(?,?,?,NOW(),?,?);";
		int sf=this.executeInsert(sql, userid,loginName,userAddress,cost,serialNumber);
		
		return sf;
	}

	public int tdshangp(int orderId, int productId, int quantity, float cost) {
		// TODO Auto-generated method stub
		String sql="insert easybuy_order_detail(orderId,productId,quantity,cost)values(?,?,?,?);";
		int sf=this.executeInsert(sql, orderId,productId,quantity,cost);
		return sf;
	}
	public int diid() {
		// TODO Auto-generated method stub
		String sql="select COUNT(1) from easybuy_order;";
		ResultSet rs=this.executeQuery(sql);
		int id=0;
		try {
			while(rs.next()){
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return id;
	}

}
