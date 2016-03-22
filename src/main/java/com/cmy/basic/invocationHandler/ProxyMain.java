package com.cmy.basic.invocationHandler;

public class ProxyMain {

	public static void main(String[] agrs) {
		// 实例化目标对象
		UserService userService = new UserServiceImpl();

		// 实例化InvocationHandler
		MyInvocationHandler invocationHandler = new MyInvocationHandler(
				userService);

		// 根据目标对象生成代理对象
		UserService myproxy = (UserService) invocationHandler.getProxy();

		// 调用代理对象的方法
		myproxy.add();
		
		System.out.println(Thread.currentThread().getContextClassLoader().getClass());
		
	}
}
