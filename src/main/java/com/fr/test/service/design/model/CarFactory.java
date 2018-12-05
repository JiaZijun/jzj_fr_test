package com.fr.test.service.design.model;

public class CarFactory {
	
	 public static CarModel carType(String carType){
		 if(carType.equals("ocar")){
			 return new Ocar();
		 }else{
			 return new Wcar();
		 }
	 }

}
