package com.cmy.java_study;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(1 << 2);
        System.out.println(1 << 1);
        
        
        String a = "abc";
        String i = "abc";
        String x = new String("abc");
        String j = getStr();
        System.out.println(a == i);
        System.out.println(a == x);
        System.out.println(a == j);
        
        System.out.println(a.hashCode());
        System.out.println(i.hashCode());
        System.out.println(x.hashCode());
        System.out.println(j.hashCode());
    } 
    
    public static String getStr(){
    	String b = "abc";
    	return b;
    }
}
