package com.util;

import java.util.List;

import com.entity.Order;
import com.entity.Product;
import com.entity.ProductCategory;

public class ProductCaPage {
	private int currentPageNo;//当前页数
	private int totalCount;//总行数
	private int pageSize=5;
	private int totalPageCount;//总页数
	private List<ProductCategory> list;
	
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
	public List<ProductCategory> getList() {
		return list;
	}
	public void setList(List<ProductCategory> list) {
		this.list = list;
	}
	
	public ProductCaPage() {
		super();
	}

	
	
	
}

