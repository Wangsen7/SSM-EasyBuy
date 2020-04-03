package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
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
	/**
	 * 查询有所有条数
	 * @return
	 */
	int selTotalCount();
	/**
	 * 查询每页的集合
	 * @param currentPageNo
	 * @param limit
	 * @return
	 */
	List<News> selCurrentPageNoAndLimit(int currentPageNo,int pageSize);
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
	 *  模糊查询分页
	 * @param title
	 * @return
	 */
	int selTotalCount(String title);
	/**
	 * 模糊查询每页的信息
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<News> selByCurrentPageNoAndLimitAndTitle(int currentPageNo,int pageSize,String title);
}
