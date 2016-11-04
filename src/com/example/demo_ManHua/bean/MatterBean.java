package com.example.demo_ManHua.bean;

public class MatterBean {
	private String imageUrl;
	private int id;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MatterBean(String imageUrl, int id) {
		super();
		this.imageUrl = imageUrl;
		this.id = id;
	}
	public MatterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MatterBean [imageUrl=" + imageUrl + ", id=" + id + "]";
	}
	
	
}
