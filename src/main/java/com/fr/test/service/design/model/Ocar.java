package com.fr.test.service.design.model;

public class Ocar extends CarModel{

	@Override
	public void start() {
		System.out.println("奥迪  无匙启动               突突突");
		
	}

	@Override
	public void stop() {
		System.out.println("奥迪  停车              ");
		
	}

}
