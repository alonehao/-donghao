package com.example.demo_ManHua.bean;

public class ChapterBean {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ChapterBean [name=" + name + ", id=" + id + "]";
	}
	public ChapterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChapterBean(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
}
