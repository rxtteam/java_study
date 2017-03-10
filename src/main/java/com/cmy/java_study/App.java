package com.cmy.java_study;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    static int count_s = 0;
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        System.out.println(1 << 2);
//        System.out.println(1 << 1);
//        
//        
//        String a = "abc";
//        String i = "abc";
//        String x = new String("abc");
//        String j = getStr();
//        System.out.println(a == i);
//        System.out.println(a == x);
//        System.out.println(a == j);
//        
//        System.out.println(a.hashCode());
//        System.out.println(i.hashCode());
//        System.out.println(x.hashCode());
//        System.out.println(j.hashCode());
        
        System.out.println(HmacUtils.hmacSha256Hex("abcdef", ""));
        
        
        Long abc = 1234567890l;
        System.out.println(abc.toString());
        
        
        System.out.println(fn(2));
        System.out.println(fn(3));
        System.out.println(fn(4));
        System.out.println(fn(5));
        System.out.println(fn(6));
        System.out.println(fn(8181));
        
        System.out.println("---------------------------");
        System.out.println(cal(100));
        digui(610,1,0);
        System.out.println("count:"+count_s);
//        print();
        
        
        ClassPathResource res = new ClassPathResource("beans.xml");  
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();  
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);  
        reader.loadBeanDefinitions(res); 
    } 
    
    
    /**
     * 从少的情况开始
     * 比如n=11，
     * 最少的情况就是2次，65
     * 最多的情况就是11次
     * @param n
     * @return
     */
    public static int cal(int n){
        int max = n;
        int min = 0;
        int count = 0;
//        int total = 0;
        
        //cal min and max situation
        if( n % 6 == 0){
            min = n / 6;
        }else{
            min = n / 6 +1;
        }
        
        for(int i = min ; i <= max ; i++ ){
            
            //step 掷骰子次数 
            for(int step = 1 ; step <= i; step ++ ){
                
            }
            
        }
        
        return max;
    }
    
    public static BigDecimal fn(int n){
        BigDecimal arr[] = new BigDecimal[n];
        arr[0] = new BigDecimal(0);
        arr[1] = new BigDecimal(1);
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]) ; 
        }
        
        return arr[n - 1];
        
        
    }
    
    public static String getStr(){
    	String b = "abc";
    	return b;
    }
     
    
    public static void print(){
        int count = 0;
        for(int i =1 ;i <= 6; i++ ){
            for(int j =1 ; j <= 6 ; j++){
                 for(int k =1 ; k <= 6 ; k ++){
                     count ++;
                     System.out.println( i + "-" + j + "-" + k);
                 }
            }
        }
        System.out.println(count);
    }
     
    
    public static void digui(int n , int level,  int total){
        
        for(int i =1 ;i <= 6; i++ ){
            if(n == level){
                count_s ++;
//                System.out.println( total + i);
            }else{
                digui(n , level +1 , i);
            }
             
        }
        
    }

}
