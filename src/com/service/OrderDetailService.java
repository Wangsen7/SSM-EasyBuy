package com.service;

import java.util.List;

import com.entity.Easybuy;
import com.entity.Order;
import com.entity.OrderDetail;
import com.util.Page;

public interface OrderDetailService {
	/**
	 * 新增订单详情
	 * @param orderDetail
	 * @return 受影响的行数
	 */
	int add(OrderDetail orderDetail);
	
	/**
	 * 我的订单
	 * @param userid
	 * @return
	 */
    List<Order> Orderlist(int userid);
/**
        * 当前订单的商品
        * @param orderid
        * @return
        */
       List<Easybuy> details(int orderid);
       /**
   	 * 获取当前页的信息
   	 * @param currPageNo
   	 * @return
   	 */
   	Page selPage(int currPageNo);

}
