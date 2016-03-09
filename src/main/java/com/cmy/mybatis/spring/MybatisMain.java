package com.cmy.mybatis.spring;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisMain {
    private static ApplicationContext ctx;  

    static 
    {  
        ctx = new ClassPathXmlApplicationContext("mybatis_spring/applicationContext.xml");  
    }        

    public static void main(String[] args)  
    {  
        UserDaoMapper mapper = (UserDaoMapper)ctx.getBean("userMapper"); 
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("得到用户id=1的用户信息");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress()); 
        System.out.println(user.getUserName()); 
        System.out.println(user.getUserAge()); 
        
//      得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表");
        List<Article> articles = mapper.getUserArticles(1);

        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle()+"--"+article.getUser().getUserName());
        }

    }  

}