package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.ProductCategoryDao;
import com.dao.impl.ProductCategoryDaoImpl;
import com.entity.News;
import com.entity.ProductCategory;
import com.service.ProductCategoryService;
import com.util.NewsPage;
import com.util.ProductCaPage;
import com.util.ProductCategoryVo;

public class ProductCategoryServiceImpl implements ProductCategoryService {
	private ProductCategoryDao productCategoryDao=new ProductCategoryDaoImpl();

	public List<ProductCategory> selByParentId(int parentId) {
		// TODO Auto-generated method stub
		return productCategoryDao.selByParentId(parentId);
	}

	public List<ProductCategoryVo> selAll() {
		List<ProductCategoryVo> vos=new ArrayList<ProductCategoryVo>();
		//一级分类    
		List<ProductCategory> cates1=productCategoryDao.selByParentId(0);
		for (ProductCategory category1 : cates1) {
			//二级分类
			ProductCategoryVo vo1=new ProductCategoryVo();
			vo1.setProductCategory(category1);
			List<ProductCategoryVo> vos2=new ArrayList<ProductCategoryVo>();
			List<ProductCategory> cates2=productCategoryDao.selByParentId(category1.getId());
			for (ProductCategory category2 : cates2) {
				//三级分类
				ProductCategoryVo vo2=new ProductCategoryVo();
				vo2.setProductCategory(category2);
				List<ProductCategoryVo> vos3=new ArrayList<ProductCategoryVo>();
				List<ProductCategory> cates3=productCategoryDao.selByParentId(category2.getId());
				for (ProductCategory category3 : cates3) {
					ProductCategoryVo vo3=new ProductCategoryVo();
					vo3.setProductCategory(category3);
					vos3.add(vo3);
				}
				vo2.setVos(vos3);
				vos2.add(vo2);
			}
			vo1.setVos(vos2);
			vos.add(vo1);
		}
		
		
		return vos;
	}
	

	
	public int selTotalCount() {
		// TODO Auto-generated method stub
		return productCategoryDao.selTotalCount();
	}
	
	
	public ProductCaPage selPageByCurrentPageNo(int currentPageNo) {
		ProductCaPage productCategory=new ProductCaPage();
		if(currentPageNo<1){
			currentPageNo=1;
		}
		productCategory.setCurrentPageNo(currentPageNo);
		int totalCount=productCategoryDao.selTotalCount();
		if(totalCount<1){
			productCategory.setList(new ArrayList<ProductCategory>());
		}else{
			productCategory.setList(productCategoryDao.sellCurrentPageNoAndLimit(productCategory.getCurrentPageNo(),productCategory.getPageSize()));
		}
		productCategory.setTotalCount(totalCount);
		// TODO Auto-generated method stub
		return productCategory;
	}
	
	public int add(String name, int parentid, int type) {
		// TODO Auto-generated method stub
		return productCategoryDao.add(name, parentid, type);
	}

	public int deletef(int id) {
		// TODO Auto-generated method stub
		return productCategoryDao.deletef(id);
	}


}
