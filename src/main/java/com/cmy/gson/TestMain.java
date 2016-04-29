package com.cmy.gson;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestMain {
	public static void main (String args[]){
		Gson gson = new Gson();
		Foo<String> foo = new Foo<String>();
		foo.value = "abc";
		System.out.println(gson.toJson(foo)); // May not serialize foo.value correctly
		
		
		//wrong result
		String json = "{\"value\":\122223235460876344485\"}";
		System.out.println(gson.fromJson(json, foo.getClass()).value ) ; // Fails to deserialize foo.value as Bar
		
		//correct result
		Type type = new TypeToken<Foo<String>>(){}.getType();
		Foo f = gson.fromJson(json, type);
		System.out.println(String.valueOf(f.value));
		
		HashMap<String, String> hm = gson.fromJson(json, HashMap.class);
		System.out.println(hm.get("value") ) ; 
		
		
		Type type1 = new TypeToken<HashMap<String,Object>>(){}.getType();
		HashMap<String, Object> hm1 = gson.fromJson(json, type1);
		System.out.println(String.valueOf(hm1.get("value"))) ; 
		
		System.out.println(String.class.getClassLoader());
		System.out.println(Foo.class.getClassLoader());
		System.out.println(Foo.class.getClassLoader().getParent());
		System.out.println(Foo.class.getClassLoader().getParent().getParent());
	}
	
}
