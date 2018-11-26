package com.fr.test.service.test;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class JsonTestService {
	
	public JsonTestService() {
		System.out.println("无参构造函数");
	}
	
	public JsonTestService(String str) {
		System.out.println("有参构造方法");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("初始化执行参数！");
	}
	
	static{
		System.out.println("静态代码块");
	}
	
	public void testJson(){
		System.out.println("测试json数据");
	}
	

	

}
