package com.cmy.mybatis.spring;

import java.util.List;

public class User {

    private int id;
    private String userName;
    private String userAge;
    private String userAddress;
    private List<Group> group;
    
    public List<Group> getGroup() {
		return group;
	}
	public void setGroup(List<Group> group) {
		this.group = group;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserAge() {
        return userAge;
    }
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}