package com.entity;

import java.io.Serializable;

public class ProductCategory implements Serializable{
	private int id;//编号
	private String name;//名字
	private int parentId;//父分类
	private int type;//类型
	private String iconClass;
	private String parentName;
	public ProductCategory(int id, String name, int parentId, int type,
			String iconClass, String parentName) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
		this.parentName = parentName;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public ProductCategory(int id, String name, int parentId, int type,
			String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}
	public ProductCategory() {
		super();
	}
	
}
