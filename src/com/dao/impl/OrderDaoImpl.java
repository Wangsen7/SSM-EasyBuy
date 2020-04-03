package com.dao.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.util.BaseDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {


	public int add(Order order) {
		int id=0;
		String sql="insert into easybuy_order(userid,loginname,userAddress,createTime,cost,serialNumber) VALUES(?,?,?,?,?,?)";
		id=this.executeInsertGetId(sql, order.getUserId(),order.getLoginName(),order.getUserAddress(),order.getCreateTime(),order.getCost(),order.getSerialNumber());
		return id;
	}

}
