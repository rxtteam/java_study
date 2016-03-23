package com.cmy.basic.generic;

class Point1<T, K> {// 声明一个泛型类

	private T var; // 声明一个泛型变量
	private K Yar;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	public K getYar() {
		return Yar;
	}

	public void setYar(K yar) {
		Yar = yar;
	}

	public Point1(T var, K yar) {
		this.var = var;
		Yar = yar;
	}

}
