package com.ideaiseletronics.web.model;

public class Product {
	
	private Long idProduct;
	private String name;
	
	public Product(Long idProduct, String name) {
		this.idProduct = idProduct;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	

}
