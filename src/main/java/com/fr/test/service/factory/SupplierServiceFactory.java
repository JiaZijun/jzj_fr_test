package com.fr.test.service.factory;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fr.test.annotation.SupplierServiceKind;
import com.fr.test.service.ISupplierService;
import com.google.common.collect.Maps;


/**
 * 工厂类 工厂模式
 * @author jzj
 * @date 2018年11月26日 下午3:07:27
 * @desc
 */
@Service
public class SupplierServiceFactory {
	
	@Resource
	private List<ISupplierService> supplierServiceList;
	
	private static final Map<String, ISupplierService> supplierServiceMap = Maps.newHashMap();
	
	@PostConstruct
	public void init(){
		System.out.println("SupplierServiceFactory init...");
		
		for (ISupplierService iSupplierService : supplierServiceList) {
			SupplierServiceKind serviceKind = iSupplierService.getClass().getAnnotation(SupplierServiceKind.class);
			String[] supplierCodes = serviceKind.supportSupplier();
			if(supplierCodes != null && supplierCodes.length > 0){
				for (String code : supplierCodes) {
					supplierServiceMap.put(code, iSupplierService);
				}	
			}
		}
		System.out.println("SupplierServiceFactory init end ... " );
		System.out.println("supplierServiceMap = " + supplierServiceMap);
	}
	
	
	public static ISupplierService getSupplierServiceByCode(String code){
		return supplierServiceMap.get(code);
	}

}
