package com.cmy.mybatis.basic;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	// 通过xml配置文件
            UserDaoMapper userDaoMapper=session.getMapper(UserDaoMapper.class);
            User user = userDaoMapper.selectUserByID(1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
            
            // 另一种调用方式
            User u1 = session.selectOne("com.cmy.mybatis.basic.UserDaoMapper.selectUserByID",1);
            System.out.println(u1.getUserAddress());
            System.out.println(u1.getUserName());  
            
        } finally {
            session.close();
        }
    }
}