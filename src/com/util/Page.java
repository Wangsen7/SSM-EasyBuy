package com.util;

import java.util.List;

import com.entity.Order;
import com.entity.Product;

public class Page {
	private int currentPageNo;//当前页数
	private int totalCount;//总行数
	private int pageSize=5;
	private int totalPageCount;//总页数
	private List<Product> list;
	
	private List<Order> list2;
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount<=0){
			totalCount=1;
		}
		this.totalPageCount=(totalCount%this.pageSize==0)?(totalCount/this.pageSize):(totalCount/this.pageSize)+1;
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public Page(int currentPageNo, int totalCount, int pageSize,
			int totalPageCount, List<Product> list) {
		super();
		this.currentPageNo = currentPageNo;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.totalPageCount = totalPageCount;
		this.list = list;
	}
	public Page() {
		super();
	}

	public List<Order> getList2() {
		return list2;
	}
	public void setList2(List<Order> list2) {
		this.list2 = list2;
	}
	
	
}
