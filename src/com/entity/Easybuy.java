package com.entity;



public class Easybuy {
	private String spname;
    private String filename;
    private int num;
    private float nuprice;
    
	public Easybuy() {
		super();
	}
	public Easybuy(String spname, String filename, int num, float nuprice) {
		super();
		this.spname = spname;
		this.filename = filename;
		this.num = num;
		this.nuprice = nuprice;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getNuprice() {
		return nuprice;
	}
	public void setNuprice(float nuprice) {
		this.nuprice = nuprice;
	}
    
}
