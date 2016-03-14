package com.cmy.mybatis.spring;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("userDaoMapper")
public interface UserDaoMapper {
	public User selectUserByID(int id);
	public List<Article> getUserArticles(int id);
	public List<User> selectUserGroup(int id);
}
