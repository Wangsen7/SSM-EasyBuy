package com.service;

import java.util.List;

import com.entity.ProductCategory;
import com.util.ProductCaPage;
import com.util.ProductCategoryVo;

public interface ProductCategoryService {
	/**
	 * 通过parentId查询集合
	 * @param parentId
	 * @return
	 */
	List<ProductCategory> selByParentId(int parentId);
	/**
	 * 查询三级集合
	 * @return
	 */
	List<ProductCategoryVo> selAll();
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
	ProductCaPage selPageByCurrentPageNo(int currentPageNo);
	
	/**
	 * 添加分类
	 */
	int add(String name,int parentid,int type);
	/**
	 * 删除分类
	 * @param id
	 * @return
	 */
	int deletef(int id);
}
