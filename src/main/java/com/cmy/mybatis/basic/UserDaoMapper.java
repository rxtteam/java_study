package com.cmy.mybatis.basic;

public interface UserDaoMapper {
	public User selectUserByID(int id);
	public int insertUser(User user);
}
