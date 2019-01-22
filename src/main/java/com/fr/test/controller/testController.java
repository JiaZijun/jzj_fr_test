package com.fr.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fr.test.bean.SupplierConfig;
import com.fr.test.service.ISupplierService;
import com.fr.test.service.factory.SupplierServiceFactory;
import com.fr.test.service.supplier.SupplierService1;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

@Controller
@RequestMapping("testCtrl")
public class testController {
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);
	
	@Resource
	private SupplierConfig supplierConfig;

	@RequestMapping("/supplier")
	@ResponseBody
	public String supplier(){
		return SupplierServiceFactory.getSupplierServiceByCode("S1").search();
	}
	
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
	
    @RequestMapping("/jc")
    @ResponseBody
	public void testjc(@RequestParam(value="tokenUrl") String tokenUrl){
    	System.out.println("===tokenUrl===" + tokenUrl);
		
	}
	
}
