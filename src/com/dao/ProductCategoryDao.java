package com.dao;

import java.util.List;

import com.entity.News;
import com.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 通过parentId查询集合
	 * @param parentId
	 * @return
	 */
	List<ProductCategory> selByParentId(int parentId);
	
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
	List<ProductCategory> sellCurrentPageNoAndLimit(int currentPageNo,int pageSize);
	
	/**
	 * 添加分类
	 */
	int add(String name,int parentid,int type);
	/**
	 *删除分类
	 */
	int deletef(int id);
	
	/**
	 * 根据type查找
	 */
	List<ProductCategory> selltype(int type);


}
