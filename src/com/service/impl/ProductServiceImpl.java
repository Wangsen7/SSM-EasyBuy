package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.entity.Product;
import com.service.ProductService;
import com.util.Page;
import com.util.ProductCategoryVo;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao=new ProductDaoImpl();
	
	public List<Product> selByCategoryLevel1IdAndLimit(int categoryLevel1Id,int limit
			) {
		// TODO Auto-generated method stub
		return productDao.selByCategoryLevel1IdAndLimit(categoryLevel1Id,limit);
	}
	
	public List<Product> selByCategoryLevel1IdOrCategoryLevel2IdOrCategoryLevel3Id(
			int CategoryLevel1Id) {
		// TODO Auto-generated method stub
		return productDao.selByCategoryLevel1IdOrCategoryLevel2IdOrCategoryLevel3Id(CategoryLevel1Id);
	}

	public Product selByid(int id) {
		// TODO Auto-generated method stub
		return productDao.selByid(id);
	}
	
	public List<Product> selByName(String name) {
		// TODO Auto-generated method stub
		return productDao.selByName(name);
	}

	public Page selPageByCurrentPageNo(int currentPageNo,int CategoryLevel1Id) {
		Page page=new Page();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		page.setCurrentPageNo(currentPageNo);
		int totalCount=productDao.selTotalCount(CategoryLevel1Id);
		if(totalCount<1){
			page.setList(new ArrayList<Product>());
		}else{
			page.setList(productDao.selByCurrentPageNoAndLimit(page.getCurrentPageNo(),page.getPageSize(), CategoryLevel1Id));
		}
		page.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return page;
	}

	public Page selPageByCurrentPageNoAndName(int currentPageNo, String name) {
		Page page=new Page();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		page.setCurrentPageNo(currentPageNo);
		int totalCount=productDao.selTotalCountByName(name);
		if(totalCount<1){
			page.setList(new ArrayList<Product>());
		}else{
			page.setList(productDao.selByCurrentPageNoAndLimitAndName(page.getCurrentPageNo(),page.getPageSize(),name));
		}
		page.setTotalCount(totalCount);
		return page;
	}


	public Page sellpage(int currentPageNo) {
		Page page=new Page();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		page.setCurrentPageNo(currentPageNo);
		int totalCount=productDao.selTotalCount();
		if(totalCount<1){
			page.setList(new ArrayList<Product>());
		}else{
			page.setList(productDao.selbuypage(page.getCurrentPageNo(),page.getPageSize()));
		}
		page.setTotalCount(totalCount);
		return page;
	}

	public int deleteSp(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteSp(id);
	}

	public int listShopping(Product product) {
		// TODO Auto-generated method stub
		return productDao.listShopping(product);
	}

	public int setShopping(Product product) {
		// TODO Auto-generated method stub
		return productDao.setShopping(product);
	}


	

	

}
