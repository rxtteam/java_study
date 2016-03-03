package com.cmy.basic.reflection;

public class BookMain {

	public static void main (String args[] ) throws ClassNotFoundException{
		
		//三种方式获取类对象
		Book book = new Book(1,"book1","小说");
		Class c1 = book.getClass();
		
		Class c2 = Class.forName("com.cmy.basic.reflection.Book");
		
		Class c3 = Book.class;
		
		System.out.println(c1 + "---" + c1.getName());
		System.out.println(c2 + "---" + c2.getName());
		System.out.println(c3 + "---" + c3.getName());
	}
}
