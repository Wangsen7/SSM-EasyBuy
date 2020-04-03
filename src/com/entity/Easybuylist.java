package com.entity;



import java.util.List;

public class Easybuylist {
    private String name;
    private String dinhao;
    private String dizi;
    private float price;
    private List<Easybuy> list;
    
	public Easybuylist() {
		super();
	}
	public Easybuylist(String name, String dinhao, String dizi, float price,
			List<Easybuy> list) {
		super();
		this.name = name;
		this.dinhao = dinhao;
		this.dizi = dizi;
		this.price = price;
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDinhao() {
		return dinhao;
	}
	public void setDinhao(String dinhao) {
		this.dinhao = dinhao;
	}
	public String getDizi() {
		return dizi;
	}
	public void setDizi(String dizi) {
		this.dizi = dizi;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Easybuy> getList() {
		return list;
	}
	public void setList(List<Easybuy> list) {
		this.list = list;
	}
    
	
}
