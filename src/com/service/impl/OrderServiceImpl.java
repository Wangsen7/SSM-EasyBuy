package com.service.impl;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.entity.Order;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService {
 private OrderDao orderDao=new OrderDaoImpl();

	public int add(Order order) {
		// TODO Auto-generated method stub
		return orderDao.add(order);
	}

}
