package com.dao;

import java.util.List;

import com.entity.Easybuy;
import com.entity.Order;

public interface OrderDao {
	/**
	 * 新增订单
	 * @param order
	 * @return id  主键
	 */
	int add(Order order);
	
	
	
}
