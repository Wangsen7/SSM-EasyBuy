package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDetailDao;
import com.dao.impl.OrderDetailDaoImpl;
import com.entity.Easybuy;
import com.entity.Order;
import com.entity.OrderDetail;
import com.service.OrderDetailService;
import com.util.Page;

public class OrderDetialServiceImpl implements OrderDetailService {
 private OrderDetailDao orderDaoDetial=new OrderDetailDaoImpl();

	public int add(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDaoDetial.add(orderDetail);
	}
	
	public List<Order> Orderlist(int userid) {
		// TODO Auto-generated method stub
		return orderDaoDetial.Orderlist(userid);
	}
public List<Easybuy> details(int orderid) {
		// TODO Auto-generated method stub
		return orderDaoDetial.details(orderid);
	}
	public Page selPage(int currPageNo) {
		// TODO Auto-generated method stub
		Page page=new Page();
		if(currPageNo<0){
			currPageNo=1;
		}
		page.setCurrentPageNo(currPageNo);
		int pagecount=orderDaoDetial.selTotalCount();
		if(pagecount<=0){
			page.setList2((new ArrayList<Order>()));
		}else{
			page.setList2(orderDaoDetial.selNewsByLimit(page.getPageSize(), page.getCurrentPageNo()));
		}
		page.setTotalCount(pagecount);
		return page;
	}

}
