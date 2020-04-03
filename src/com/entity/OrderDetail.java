package com.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private int id;//编号
	private int orderId;//订单id
	private int productId;//商品id
	private int quantity;//数量
	private float cost;//金额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public OrderDetail(int id, int orderId, int productId, int quantity,
			float cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	public OrderDetail() {
		super();
	}
	
}
