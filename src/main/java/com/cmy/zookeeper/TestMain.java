package com.cmy.zookeeper;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ZKConnection zkConnection = new ZKConnection();
		zkConnection.connect();
		zkConnection.create();
	}

}
