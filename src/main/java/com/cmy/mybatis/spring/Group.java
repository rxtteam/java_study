package com.cmy.mybatis.spring;

public class Group {
	private int id;
	private String name;
	private int createDate;
	
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
	public int getCreatDate() {
		return this.createDate;
	}
	public void setCreatDate(int createDate) {
		this.createDate = createDate;
	}
}
