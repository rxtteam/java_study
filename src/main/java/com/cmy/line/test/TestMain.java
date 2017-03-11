package com.cmy.line.test;

import java.math.BigDecimal;

public class TestMain {

	public static void main(String args[]) {

		// System.out.println(fn(-5));
		// System.out.println(fn(0));
		// System.out.println(fn(1));
		// System.out.println(fn(2));
		// System.out.println(fn(3));
		// System.out.println(fn(4));
		// System.out.println(fn(5));
		// System.out.println(fn(6));
		// System.out.println(fn(20));
		// System.out.println(fn(100));
		// System.out.println(fn(1000));
		// System.out.println(fn(8180));
		// System.out.println(fn(8181));

		// System.out.println(fn1(1));
		// System.out.println(fn1(2));
		// System.out.println(fn1(3));
		// System.out.println(fn1(4));
		// System.out.println(fn1(5));
		// System.out.println(fn1(6));
		// System.out.println(fn1(20));
		// System.out.println(fn1(21));
		// System.out.println(fn1(500));
		// System.out.println(fn1(1000));
		// System.out.println(fn1(8181));
		// System.out.println(fn1(8182));

//		digui(10, 1, 0);
		cal(610);
		System.out.println(count_s);
	}

	public static long count_s = 0;
	public static void cal(int masu){
		int max = masu;  //max step: n * 1 = n
		int min = 0;  //min step 
		if(masu % 6 ==0  ){
			min = masu / 6;
		}else{
			min = masu / 6 +1;
		} 
		System.out.println("min:"+min);
		System.out.println("max:"+max);
		
		for ( int i = min; i <= max ; i++){
			recursion6( i , 1 , 0 , masu );
		}
	}

	/**
	 * 
	 * @param n :max level
	 * @param level: now level
	 * @param total
	 */
	public static void recursion6(int n, int level, int total , int masu) {
		for (int i = 1; i <= 6; i++) {
			if (n == level) {
				int totalTemp = total;
				total = total + i;
				if (total == masu ){
					count_s++;
				}
				total = totalTemp;
				// System.out.println( total + i);
			} else {
				recursion6(n, level + 1, i + total  , masu);
			}
		}
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int fn3(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fn3(n - 1) + fn3(n - 2);
		}
	}

	public static long fn1(int n) {
		long arr[] = new long[n];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n - 1];
	}

	public static BigDecimal fn(int n) {
		if (n < 0) {
			return new BigDecimal(-1);
		} else if (n == 0) {
			return new BigDecimal(0);
		} else if (n == 1) {
			return new BigDecimal(1);
		} else {
			BigDecimal arr[] = new BigDecimal[n];
			arr[0] = new BigDecimal(0);
			arr[1] = new BigDecimal(1);
			for (int i = 2; i < arr.length; i++) {
				arr[i] = arr[i - 1].add(arr[i - 2]);
			}
			return arr[n - 1];
		}
	}

	// 从最少的情况开始到最多的情况，每种累加

}
