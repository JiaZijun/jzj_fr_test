package com.fr.test.service.supplier;

import org.springframework.stereotype.Service;

import com.fr.test.annotation.SupplierServiceKind;
import com.fr.test.service.ISupplierService;

@SupplierServiceKind(supportSupplier = {"S3","S4"})
@Service
public class SupplierService2 implements ISupplierService{

	@Override
	public String search() {
		return "SupplierService2 search....";
	}

}
