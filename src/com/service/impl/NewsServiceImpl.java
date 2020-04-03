package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.NewsDao;
import com.dao.impl.NewsDaoImpl;
import com.entity.News;
import com.service.NewsService;
import com.util.NewsPage;
import com.util.Page;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao=new NewsDaoImpl();
	
	public List<News> selByLimit(int limit) {
		// TODO Auto-generated method stub
		return newsDao.selByLimit(limit);
	}
	

	public List<News> selAll() {
		// TODO Auto-generated method stub
		return newsDao.selAll();
	}
	
	public NewsPage selPageByCurrentPageNo(int currentPageNo) {
		NewsPage newsPage=new NewsPage();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		newsPage.setCurrentPageNo(currentPageNo);
		int totalCount=newsDao.selTotalCount();
		if(totalCount<1){
			newsPage.setList(new ArrayList<News>());
		}else{
			newsPage.setList(newsDao.selCurrentPageNoAndLimit(newsPage.getCurrentPageNo(),newsPage.getPageSize()));
		}
		newsPage.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return newsPage;
	}

	public List<News> selNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.selNewsById(id);
	}

	public int addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}

	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.updateNews(news);
	}
	
	public int deleteNews(int id) {
		// TODO Auto-generated method stub
		return newsDao.deleteNews(id);
	}
	
	public NewsPage selByCurrentPageNoAndTitle(int currentPageNo, String title) {
		NewsPage newsPage=new NewsPage();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		newsPage.setCurrentPageNo(currentPageNo);
		int totalCount=newsDao.selTotalCount(title);
		if(totalCount<1){
			newsPage.setList(new ArrayList<News>());
		}else{
			newsPage.setList(newsDao.selByCurrentPageNoAndLimitAndTitle(newsPage.getCurrentPageNo(),newsPage.getPageSize(), title));
		}
		newsPage.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return newsPage;
	}
	

}
