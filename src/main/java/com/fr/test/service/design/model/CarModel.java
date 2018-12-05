package com.fr.test.service.design.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fr.test.service.test.JsonTestService;

/**
 * @author jzj
 * @date 2018年12月5日 下午2:10:13
 * @desc 设计模式_模板模式
 */
public abstract class CarModel {
	
	
	public abstract void start();
	
	public abstract void stop();
	
	public final void exceut(){
		System.out.println("----------------------------");
		JsonTestService service = new JsonTestService();
		service.testJson();
		start();
		stop();
	}

}
