package com.cmy.basic.reflection;

import java.lang.reflect.Method;

public class SimpleReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method[] methods = SimpleReflection.class.getMethods();

		for(Method method : methods){
		    System.out.println("method = " + method.getName());
		}
	}
	
	public static void f1(){
		
	}

}
