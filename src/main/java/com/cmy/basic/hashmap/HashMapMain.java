package com.cmy.basic.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapMain {

	public static void main(String[] agrs) {
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("1", "dd");
		m1.put("2", "adg");
		m1.put("a", "jhgds");
		m1.put("s", "hgdsfad");
		m1.put("bv", "sdafs");
		
		// 第一种:
//		Map map = new HashMap();
		Iterator iter1 = m1.entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry entry = (Map.Entry) iter1.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.println(key+":"+val);
		}
		// 效率高,以后一定要使用此种方式！
		
		
		// 第二种:
//		Map map = new HashMap();
		Iterator iter2 = m1.keySet().iterator();
		while (iter2.hasNext()) {
			Object key = iter2.next();
			Object val = m1.get(key);
			System.out.println(key+":"+val);
		}
		// 效率低,以后尽量少使用！

		
//		m1.entrySet();
//		m1.keySet();

	}
}
