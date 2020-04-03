package com.dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
	/**
	 * 只根据CategoryLevel1Id获取Product信息
	 * @param categoryLevel1Id
	 * @param limit
	 * @return
	 */
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
	 * 通过CategoryLevel1Id查找所有信息的条数
	 * @param CategoryLevel1Id
	 * @return
	 */
	int selTotalCount(int CategoryLevel1Id);
	/**
	 * 通过CategoryLevel1Id查找每页的集合
	 * @param currentPageNo
	 * @param pageSize
	 * @param CategoryLevel1Id
	 * @return
	 */
	List<Product> selByCurrentPageNoAndLimit(int currentPageNo,int pageSize,int CategoryLevel1Id);
	/**
	 * 通过name查找所有信息的条数
	 * @param name
	 * @return
	 */
	int selTotalCountByName(String name);
	/**
	 * 通过name查找每页的集合
	 * @param currentPageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	List<Product> selByCurrentPageNoAndLimitAndName(int currentPageNo,int pageSize,String name);
	
	/**
	 * 商品信息展示
	 */
	
	int selTotalCount();
	
	
	List<Product> selbuypage(int currentPageNo,int pageSize);
	
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
	/**
	 * 添加订单到数据库
	 * @param userid
	 * @param loginName
	 * @param userAddress
	 * @param cost
	 * @param serialNumber
	 * @return
	 */
	int tdindan(int userid, String loginName, String userAddress,
			float cost, String serialNumber);
	/**
	 * 添加商品订单详情
	 * @param orderId
	 * @param productId
	 * @param quantity
	 * @param cost
	 * @return
	 */
	int tdshangp(int orderId,int productId,int quantity,float cost);
	/**
	 * 获取订单信息
	 * @return
	 */
	int diid();
	
}
