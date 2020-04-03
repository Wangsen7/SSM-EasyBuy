package com.util;

import java.util.List;

import com.entity.News;


public class NewsPage {
	private int currentPageNo;//当前页数
	private int totalCount;//总行数
	private int pageSize=8;
	private int totalPageCount;//总页数
	private List<News> list;
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
		this.totalPageCount=this.totalPageCount=(totalCount%this.pageSize==0)?(totalCount/this.pageSize):(totalCount/this.pageSize)+1;
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
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	public NewsPage(int currentPageNo, int totalCount, int pageSize,
			int totalPageCount, List<News> list) {
		super();
		this.currentPageNo = currentPageNo;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.totalPageCount = totalPageCount;
		this.list = list;
	}
	public NewsPage() {
		super();
	}
	
}
