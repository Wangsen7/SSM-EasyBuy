package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDetailDao;
import com.entity.Easybuy;
import com.entity.Order;
import com.entity.OrderDetail;
import com.util.BaseDao;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {


	public int add(OrderDetail orderDetail) {
		int hs=0;
		String sql="insert into easybuy_order_detail(orderid,productId,quantity,cost) VALUES(?,?,?,?)";
		hs=this.executeUpdate(sql, orderDetail.getOrderId(),orderDetail.getProductId(),orderDetail.getQuantity(),orderDetail.getCost());
		return hs;
	}

	
	public List<Order> Orderlist(int userid) {
		// TODO Auto-generated method stub
		List<Order> list=new ArrayList<Order>();
		Order order=null;	
		String sql="select * from easybuy_order where userid=?;";
		ResultSet rs=this.executeQuery(sql, userid);
		try {
			while(rs.next()){
				order=new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getDate(5), rs.getFloat(6), rs.getString(7));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
public List<Easybuy> details(int orderid) {
		// TODO Auto-generated method stub
		List<Easybuy> list=new ArrayList<Easybuy>();
		String sql="select d.name,d.fileName,a.quantity,a.cost from easybuy_order_detail AS a,easybuy_product AS d where a.productId=d.id and a.orderId=?";
		ResultSet rs=this.executeQuery(sql, orderid);
		try {
			while(rs.next()){
				Easybuy detail=new Easybuy(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				list.add(detail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	public int selTotalCount() {
		// TODO Auto-generated method stub
		String sql="select count(1) from easybuy_order";
		int  line=0;
		ResultSet rs=null;
		rs=this.executeQuery(sql);
		try {
			while(rs.next()){
				line=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		// TODO Auto-generated method stub
		return line;
		
	}
	public List<Order> selNewsByLimit(int pageSize, int currPageNo) {
		// TODO Auto-generated method stub
		List<Order> list=new ArrayList<Order>();
		String sql="select * from easybuy_order order by createTime desc LIMIT ?,?";
		ResultSet rs=null;
		rs=this.executeQuery(sql,(currPageNo-1)*pageSize,pageSize);
		try {
			while(rs.next()){
				Order news=new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getFloat(6), rs.getString(7));
				list.add(news);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}
}
