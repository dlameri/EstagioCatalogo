package com.ideaiseletronics.web.domain;

public class Subcategory {

	private Long id;
	private String name;
	private Category category;
	
	public Subcategory() {
		
	}

	public Subcategory(Long id, String name, Category category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
}
