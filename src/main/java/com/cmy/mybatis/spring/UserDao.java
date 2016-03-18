package com.cmy.mybatis.spring;

public class UserDao {
	public void insertTest(User user,UserDaoMapper userMapper) throws Exception{
		userMapper.insertUser(user);
		int a = 1 / 0;
	}
}
