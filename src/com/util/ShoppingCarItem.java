package com.util;

import com.entity.Product;
//购物车条目
public class ShoppingCarItem {
	private Product product;//商品
	private int num;//商品数量
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ShoppingCarItem(Product product, int num) {
		super();
		this.product = product;
		this.num = num;
	}
	public ShoppingCarItem() {
		super();
	}
	

}
