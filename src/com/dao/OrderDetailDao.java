package com.dao;

import java.util.List;

import com.entity.Easybuy;
import com.entity.Order;
import com.entity.OrderDetail;
import com.util.Page;

public interface OrderDetailDao {
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
	 * 查询新闻总记录数
	 * @return
	 */
	int selTotalCount();
	/**
	 * 全部订单
	 * @param pageSize 每页的页大小
	 * @param currPageNo 当前页码
	 * @return
	 */
	List<Order> selNewsByLimit(int pageSize,int currPageNo);
/**
     * 当前订单的商品
     * @param orderid
     * @return
     */
    List<Easybuy> details(int orderid);


}
