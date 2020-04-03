package com.service;

import com.entity.Order;

public interface OrderService {
	/**
	 * 新增订单
	 * @param order
	 * @return id  主键
	 */
	int add(Order order);

}
