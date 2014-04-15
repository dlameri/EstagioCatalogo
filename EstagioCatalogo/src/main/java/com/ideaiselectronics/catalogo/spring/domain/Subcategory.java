package com.ideaiselectronics.catalogo.spring.domain;

import java.util.List;

import javax.persistence.Column;



public class Subcategory {
	private Long id;
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	private String name;
	
	private Category category;
	
	@Column(name="BO_ATIVO", nullable=false)
	private Boolean active;
	
	private List<Product> products;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String toJson() {
		return "{" 
					+"\"id\":" + this.id + ","
					+"\"name\":" + this.name
				+ "}";
	}
	
}
