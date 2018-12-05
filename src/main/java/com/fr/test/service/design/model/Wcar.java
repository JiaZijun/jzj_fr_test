package com.fr.test.service.design.model;

import org.springframework.stereotype.Service;

/**
 * 
 * @author jzj
 * @date 2018年12月5日 下午2:16:37
 * @desc 大众
 */

@Service
public class Wcar extends CarModel{

	@Override
	public void start() {
		 System.out.println("大众车启动 。。。。。。。。突突突");
	}

	@Override
	public void stop() {
		 System.out.println("大众车停车。。。。。。。。。");
	}

}
