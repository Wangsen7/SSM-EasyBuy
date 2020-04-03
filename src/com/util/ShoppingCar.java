package com.util;

import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

//购物车
public class ShoppingCar {
	private List<ShoppingCarItem> list=new ArrayList<ShoppingCarItem>();//购物车所有条目
	private float sum;//总价
	public List<ShoppingCarItem> getList() {
		return list;
	}
	public void setList(List<ShoppingCarItem> list) {
		this.list = list;
	}
	public float getSum() {
		totalSum();
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public ShoppingCar(List<ShoppingCarItem> list, float sum) {
		super();
		this.list = list;
		this.sum = sum;
	}
	public ShoppingCar() {
		super();
	}
	/**
	 * 购物车总价
	 */
	public void totalSum(){
		sum=0;
		for(ShoppingCarItem item : list){
			sum+=(item.getProduct().getPrice())*item.getNum();
		}
	}
	/**
	 * 删除购物车中的商品
	 * @param index该购物车条目的下标
	 */
	public void delete(int index){
		list.remove(index);
	}
	/**
	 * 添加商品到购物车
	 * 商品已存在     只添加数量
	 * 商品不存在    添加商品和数量
	 * @param product
	 * @param num
	 * @return  1：商品已存在   库存充足   修改数量成功   -1：商品已存在    库存不充足  添加数量失败   2：不存在    添加商品成功  -2：不存在  库存不足
	 */
	public int add(Product product,int num){
		int reg=0;
		boolean isExist=false;
		for(ShoppingCarItem item : list){
			Product product1=item.getProduct();
			if(product1.getId()==product.getId()){
				//商品存在
				if(product.getStock()>=num+item.getNum()){
					item.setNum(num+item.getNum());
					reg=1; //商品已存在   库存充足   修改数量成功
				}else{
					reg=-1;//商品已存在    库存不充足  添加数量失败
				}
				isExist=true;
				break;
			}
		}
		if(!isExist){
			//不存在
			if(product.getStock()>=num){
				ShoppingCarItem shoppingCarItem=new ShoppingCarItem(product,num);
				list.add(shoppingCarItem);
				reg=2;//不存在    添加商品成功
			}else{
				reg=-2;//不存在  库存不足
			}
		}
		return reg;
	}
	//购物车减
	public int jian(Product product,int num){
		int reg=0;
		for(ShoppingCarItem item : list){
			Product product1=item.getProduct();
			if(product1.getId()==product.getId()){
				item.setNum(item.getNum()-num);
				reg=1;
			}
		}
		return reg;
	}

}
