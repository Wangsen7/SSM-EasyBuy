package com.util;

import java.util.ArrayList;
import java.util.List;

import com.entity.Product;
//浏览历史
public class HistoryProduct {
	private List<Product> list=new ArrayList<Product>();

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public HistoryProduct(List<Product> list) {
		super();
		this.list = list;
	}

	public HistoryProduct() {
		super();
	}
	public void add(Product product){
		
		boolean flag=true;
		for(Product product1 : list){
			if(product1.getId()==product.getId()){
				flag=false;
			}
		}
		if(flag){
			list.add(product);
			
		}
		
	}

}
