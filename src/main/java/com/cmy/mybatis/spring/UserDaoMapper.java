package com.cmy.mybatis.spring;

import java.util.List;

public interface UserDaoMapper {
	public User selectUserByID(int id);
	public List<Article> getUserArticles(int id);
	public List<User> selectUserGroup(int id);
}
