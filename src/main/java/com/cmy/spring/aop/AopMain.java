package com.cmy.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        // 创建spring IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring_aop.xml");
        // 从IOC容器中获取bean实例

        ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);
        // ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)
        // applicationContext.getBean("arithmeticCalculator");
        int result = arithmeticCalculator.add(4, 6);
        System.out.println(result);
        result = arithmeticCalculator.sub(4, 6);
        System.out.println(result);
        result = arithmeticCalculator.mul(4, 6);
        System.out.println(result);
        result = arithmeticCalculator.div(4, 2);
        System.out.println(result);

        // 这样不能接受通知
        ArithmeticCalculatorImpl impl = new ArithmeticCalculatorImpl();
        impl.add(1, 1);
        impl.test();

        // 使用类代理也可以
        ArithmeticCalculatorImpl i1 = (ArithmeticCalculatorImpl) applicationContext
                .getBean(ArithmeticCalculatorImpl.class);
        i1.add(66, 66);
        i1.test();
    }
}