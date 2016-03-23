package com.cmy.basic.generic;

public class PointMain {
	public static void main(String[] args) {

		Point1<Integer, String> point = new Point1<Integer, String>(20, "北纬");
		System.out.println("x坐标" + point.getVar());
		System.out.println("y坐标" + point.getYar());

	}
}
