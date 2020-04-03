package com.util;

import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

//收藏商品
public class CollectProduct {
	private List<Product> list=new ArrayList<Product>();

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public CollectProduct(List<Product> list) {
		super();
		this.list = list;
	}

	public CollectProduct() {
		super();
	}
	public int addCollectProduct(Product product){
		int reg=0;
		boolean flag=true;
		for(Product product1 : list){
			if(product1.getId()==product.getId()){
				flag=false;
			}
		}
		if(flag){
			list.add(product);
			reg=1;
		}
		return reg;
	}
	public void deleteCollectProduct(int index){
		list.remove(index);
	}
}
