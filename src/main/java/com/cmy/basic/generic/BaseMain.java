package com.cmy.basic.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class BaseMain {

	public static void main(String[] args) {

//        Base<String> base = new Base<String>();
//        System.out.println(base.getEntityClass());                        //打印输出 null
    //    System.out.println(base.getEntityName());                //抛出 NullPointerException 异常
    //    System.out.println(base.getEntitySimpleName()); //抛出 NullPointerException 异常
        Child child = new Child();
        System.out.println(child.getEntityClass());
        System.out.println(child.getEntityName());
        System.out.println(child.getEntitySimpleName());
        
        
        
        
        
        
        
        
        
        
        /**
         * 泛型编译后会去参数化（擦拭法），因此无法直接用反射获取泛型的参数类型
         * 可以把泛型用做一个方法的参数类型，方法可以保留参数的相关信息，这样就可以用反射先获取方法的信息
         * 然后再进一步获取泛型参数的相关信息，这样就得到了泛型的实际参数类型
         */
        try {
            Class<?> clazz = BaseMain.class; //取得 Class
            Method method = clazz.getDeclaredMethod("applyCollection", Collection.class,List.class); //取得方法
            Type[] type = method.getGenericParameterTypes(); //取得泛型类型参数集
            ParameterizedType ptype = (ParameterizedType)type[0];//将其转成参数化类型,因为在方法中泛型是参数,且Number是第一个类型参数
            Type[] typeReal = ptype.getActualTypeArguments(); //取得参数的实际类型
            System.out.println(typeReal[0]); //取出第一个元素

            ParameterizedType ptype1 = (ParameterizedType)type[1];
            Type[] typeReal1 = ptype1.getActualTypeArguments();
            System.out.println(typeReal1[0]);
//            System.out.println(type.length);
//            ParameterizedType ptype1 = (Param eterizedType)type[0];//将其转成参数化类型,因为在方法中泛型是参数,且Number是第一个类型参数
//            type = ptype1.getActualTypeArguments(); //取得参数的实际类型
//            System.out.println(type[1]); //取出第一个元素
//            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	
	
    //声明一个空的方法,并将泛型用做为方法的参数类型
    public void applyCollection(Collection<Number> collection, List<String> list){
        
    }
}
