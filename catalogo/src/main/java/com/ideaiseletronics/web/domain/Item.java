package com.ideaiseletronics.web.domain;

public class Item {

	private Long id;
	private String name;
	private String longDescription;
	private String shortDescription;
	private Integer weight;
	private Integer warranty;
	private String brand;
	private String model;
	private Subcategory subcategory;
	private Category category;
	private Dimensions dimensions;

	public Item() {
		
	}

	public Item(Long id, String name, String longDescription,
			String shortDescription, Integer weight, Integer warranty,
			String brand, String model, Subcategory subcategory,
			Category category, Dimensions dimensions) {
		this.id = id;
		this.name = name;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		this.weight = weight;
		this.warranty = warranty;
		this.brand = brand;
		this.model = model;
		this.subcategory = subcategory;
		this.category = category;
		this.dimensions = dimensions;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public Category getCategory() {
		return category;
	}
	
}