package com.util;

import java.util.List;

import com.entity.ProductCategory;

public class ProductCategoryVo {
	private ProductCategory productCategory;//当前分类
	private List<ProductCategoryVo> vos;//当前分类的子类
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public List<ProductCategoryVo> getVos() {
		return vos;
	}
	public void setVos(List<ProductCategoryVo> vos) {
		this.vos = vos;
	}
	public ProductCategoryVo(ProductCategory productCategory,
			List<ProductCategoryVo> vos) {
		super();
		this.productCategory = productCategory;
		this.vos = vos;
	}
	public ProductCategoryVo() {
		super();
	}
	

}
