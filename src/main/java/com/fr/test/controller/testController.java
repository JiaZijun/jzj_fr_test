package com.fr.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fr.test.bean.SupplierConfig;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

@Controller
@RequestMapping("testCtrl")
public class testController {
	
	@Resource
	private SupplierConfig supplierConfig;

	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "哈哈测试成功!";
	}
	
	@RequestMapping("/haha")
	public String haha(){
		return "main";
	}
	
	@RequestMapping("/config")
	@ResponseBody
	public String config(){
		return supplierConfig.getSystemIdentity()+"--"+supplierConfig.getPassword();
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Map<String,String> json(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("aa", "测试");
		map.put("bb", "成功");
		return map;
	}
	
}
