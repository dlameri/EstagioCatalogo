package com.ideaiselectronics.catalogo.spring.domain.json;

import java.util.List;

public class CategoryJSON {
	
	private Long id;
	private String name;
	private Boolean active;
	private List<LinkJSON> links;
	
	private List<SubcategoryJSON> subcategories;
	
	public CategoryJSON() {

	}

	public CategoryJSON(Long id, String name, Boolean active, List<LinkJSON> links) {
		this.id = id;
		this.name = name;
		this.active = active;
		this.links = links;
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
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public List<LinkJSON> getLinks() {
		return links;
	}
	
	public void setLinks(List<LinkJSON> links) {
		this.links = links;
	}
	
	public List<SubcategoryJSON> getSubcategories() {
		return subcategories;
	}
	
	public void setSubcategories(List<SubcategoryJSON> subcategories) {
		this.subcategories = subcategories;
	}

}
