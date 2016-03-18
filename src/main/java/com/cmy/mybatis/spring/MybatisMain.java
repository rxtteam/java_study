package com.cmy.mybatis.spring;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class MybatisMain {
    private static ApplicationContext ctx;  
    static UserDao userDao;
    
    static 
    {  
        ctx = new ClassPathXmlApplicationContext("mybatis_spring/applicationContext.xml");  
    }       
    
    @Transactional
    public static void main(String[] args) 
    {  
        UserDaoMapper userMapper = (UserDaoMapper)ctx.getBean("userDaoMapper"); 
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("===============测试get =======================");
        System.out.println("得到用户id=1的用户信息");
        User user = userMapper.selectUserByID(1);
        System.out.println(user.getUserAddress()); 
        System.out.println(user.getUserName()); 
        System.out.println(user.getUserAge()); 
        
        
        //得到文章列表测试--has a,嵌套resulmap，是一次查询
        System.out.println("===============测试has one,嵌套resul map=======================");
        List<Article> articles = userMapper.getUserArticles(1);
        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle()+"--"+article.getUser().getUserName());
        }
        
        //得到文章列表测试--has a,嵌套select,在开启lazy load之后会多一次读取
        System.out.println("===============测试has one,嵌套select=======================");
        ArticleDaoMapper articleDaoMapper =  (ArticleDaoMapper)ctx.getBean("articleDaoMapper");
        Article a2 = articleDaoMapper.getArticleById(1);
        System.out.println(a2.getId()+"--"+a2.getTitle()+"--"+a2.getContent());
        System.out.println(a2.getUser().getId()+"--"+a2.getUser().getUserName());
        
        
        //得到用户组关系--has many,嵌套select
        System.out.println("===============测试has many=======================");
        List<User> userList = userMapper.selectUserGroup(1);
        for(User u : userList){
        	System.out.println(u.getUserAddress()+"--"+u.getUserName());
        	for(Group group : u.getGroup()){
        		System.out.println(group.getName());
        	}
        }
        
        //insert
        System.out.println("===============测试insert=======================");
        User u2 = new User();
        u2.setUserName("adsf");
        u2.setUserAge("11");
        u2.setUserAddress("addd");
//        userMapper.insertUser(u2);
//        userMapper.insertUser(u2);
//        int a = 1 / 0;
        
        userDao = (UserDao)ctx.getBean("userDao");
        try{
        	userDao.insertTest(u2,userMapper);
        }catch (Exception  e){
        	
        }
        
    }  

}