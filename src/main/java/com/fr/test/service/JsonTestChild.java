package com.fr.test.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JsonTestChild extends JsonTestService {
    public JsonTestChild() {
        System.out.println("子类无参构造函数");
    }

    public JsonTestChild(String str) {
        System.out.println("子类有参构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("子类初始化执行参数！");
    }

    static{
        System.out.println("子类静态代码块");
    }

    public void testJson(){
        System.out.println("子类测试json数据");
    }


}
