package com.service;

import java.util.List;

import com.entity.News;
import com.util.NewsPage;


public interface NewsService {
	/**
	 * 查询前几条信息集合
	 * @param limit
	 * @return
	 */
	List<News> selByLimit(int limit);
	/**
	 * 查询所有信息
	 * @return
	 */
	List<News> selAll();
	NewsPage selPageByCurrentPageNo(int currentPageNo);
	/**
	 * 通过ID查询News
	 * @param id
	 * @return
	 */
	List<News> selNewsById(int id);
	/**
	 * 添加News
	 * @param news
	 * @return
	 */
	int addNews(News news);
	/**
	 * 修改News
	 * @param news
	 * @return
	 */
	int updateNews(News news);
	/**
	 * 删除id
	 * @param id
	 * @return
	 */
	int deleteNews(int id);
	/**
	 * 通过当前页获取NewsPage
	 * @param currentPageNo
	 * @return
	 */
	NewsPage selByCurrentPageNoAndTitle(int currentPageNo,String title);
}
