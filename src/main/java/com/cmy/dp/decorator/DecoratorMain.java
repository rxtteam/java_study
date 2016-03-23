package com.cmy.dp.decorator;

public class DecoratorMain {
    public static void main(String[] args) {  
    	  
        Competitor com = new Competitor();  
  
        // 加入了跳舞修饰，decorator 的sing() 方法中被动态添加了dance 修饰  
  
        CompetitorDecorator decorator = new CompetitorDecoratorA(com);  
  
        // 在上面修饰的基础上，加入背景音乐修饰  
  
        decorator = new CompetitorDecoratorB(decorator);  
  
        // 在上面修饰的基础上，加上悲惨的身世介绍  
  
        decorator = new CompetitorDecoratorC(decorator);  
  
        decorator.sing();  
        //最早装饰的类，最先发挥作用
  
        System.out.println("满场尖叫，满分通过！！！！！");  
  
    }  
	
}
