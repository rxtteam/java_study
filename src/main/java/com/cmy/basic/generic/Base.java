package com.cmy.basic.generic;
import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unchecked")
public class Base<T> {

	/*
	从打印出的结果看来，类.class 与 getClass() 的区别很明了了，getClass() 获取的是实际运行的类的字节码，它不一定是当前类的 Class，有可能是当前类的子类的 Class，具体是哪
	个类的 Class，需要根据实际运行的类来确定，new 哪个类，getClass() 获取的就是哪个类的 Class，而 类.class 获取得到的 Class 永远只能是该类的 Class，这点是有很大的区别的。
	如果 getClass() 理解了，那 clazz.getGenericSuperclass() 也应该能够理解了的，千万不要以为 clazz.getGenericSuperclass() 获取得到的是 Object 类那就成了，
	实际上假如当前运行的类是 Base 类的子类，那么 clazz.getGenericSuperclass() 获取得到的就是 Base 类。
	(Class<T>) parameterizedType[0]，怎么就知道第一个参数（parameterizedType[0]）就是该泛型的实际类型呢？很简单，因为 Base<T> 的泛型的类型
	参数列表中只有一个参数，所以，第一个元素就是泛型 T 的实际参数类型。
	
	
	好了，文章接近尾声了，如果你能理解透这个例子，你可以将这个思想运用到 DAO 层面上来，以 Base 类作为所有 DAO 实现类的基类，在 Base 类里面实现数据库的 CURD 等基本
	操作，然后再使所有具体的 DAO 类来实现这个基类，那么，实现这个基类的所有的具体的 DAO 都不必再实现数据库的 CURD 等基本操作了，这无疑是一个很棒的做法。
    */
    private Class<T> entityClass;
    
    //代码块,也可将其放置到构造子中
    {
        entityClass =(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            
    }
    
    //泛型的实际类型参数的类全名
    public String getEntityName(){
        
        return entityClass.getName();
    }
    
    //泛型的实际类型参数的类名
    public String getEntitySimpleName(){
        
        return entityClass.getSimpleName();
    }

    //泛型的实际类型参数的Class
    public Class<T> getEntityClass() {
        return entityClass;
    }
    
}