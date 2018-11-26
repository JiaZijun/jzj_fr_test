package com.fr.test.service.supplier;

import org.springframework.stereotype.Service;

import com.fr.test.annotation.SupplierServiceKind;
import com.fr.test.service.ISupplierService;

@SupplierServiceKind(supportSupplier = {"S1","S2"})
@Service
public class SupplierService1 implements ISupplierService{

	@Override
	public String search() {
		return "SupplierService1 search...";
	}

}
