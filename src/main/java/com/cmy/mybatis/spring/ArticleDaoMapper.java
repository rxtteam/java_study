package com.cmy.mybatis.spring;

import org.springframework.stereotype.Component;

@Component("articleDaoMapper")
public interface ArticleDaoMapper {
	public Article getArticleById(int id);

}
