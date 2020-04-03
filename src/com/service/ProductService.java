package com.service;

import java.util.List;

import com.entity.Product;
import com.util.Page;
import com.util.ProductCategoryVo;

public interface ProductService {
	List<Product> selByCategoryLevel1IdAndLimit(int categoryLevel1Id,int limit);
	/**Product中的CategoryLevel1Id或CategoryLevel2Id或CategoryLevel3Id与ProductCategory中的id是主外键挂席
	 * 通过CategoryLevel1Id查找所有信息集合
	 * @param CategoryLevel1Id
	 * @return
	 */
	List<Product> selByCategoryLevel1IdOrCategoryLevel2IdOrCategoryLevel3Id(int CategoryLevel1Id);
	/**
	 * 通过id获得对象
	 * @param id
	 * @return
	 */
	Product selByid(int id);
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	List<Product> selByName(String name);
	/**
	 * 通过CategoryLevel1Id返回Page对象
	 * @param currentPageNo
	 * @param CategoryLevel1Id
	 * @return
	 */
	Page selPageByCurrentPageNo(int currentPageNo,int CategoryLevel1Id);
	/**
	 * 通name返回Page对象
	 * @param currentPageNo
	 * @param CategoryLevel1Id
	 * @return
	 */
	Page selPageByCurrentPageNoAndName(int currentPageNo,String name);
	
	/**
	 * 商品信息展示
	 */
	Page sellpage(int currentPageNo);
	
	/**
	 * 删除商品
	 */
	int deleteSp(int id);
	

	/**
	 * 添加商品
	 */
	int listShopping(Product product);
	/**
	 * 修改商品
	 */
	int setShopping(Product product);
	
	

	
}
