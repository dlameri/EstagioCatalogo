package com.ideaiseletronics.web.domain;

import java.util.List;

public class Product {

	private Long id;
	private Long sku;
	private double priceFrom;
	private double priceFor;
	private String optionName;
	private String optionValue;
	private Integer stock;
	private Item item;
	private List<Image> images;
	
	public Product() {
		
	}

	public Product(Long id, Long sku, double priceFrom, double priceFor,
			String optionName, String optionValue, Integer stock, Item item,
			List<Image> images) {
		this.id = id;
		this.sku = sku;
		this.priceFrom = priceFrom;
		this.priceFor = priceFor;
		this.optionName = optionName;
		this.optionValue = optionValue;
		this.stock = stock;
		this.item = item;
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	public Item getItem() {
		return item;
	}
	
	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image getImageMain() {
		for (Image image : this.images) {
			if( image.getMain() ){
				return image;
			}
		}
		
		return null;
	}
	
	public boolean hasImageMain() {
		return ( getImageMain() != null );
	}
	

}
