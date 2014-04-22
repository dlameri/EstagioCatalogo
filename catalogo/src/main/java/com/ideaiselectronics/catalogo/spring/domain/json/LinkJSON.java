package com.ideaiselectronics.catalogo.spring.domain.json;

public class LinkJSON {
	
	private String href;
	private String name;
	
	public LinkJSON() {

	}

	public LinkJSON(String href, String name) {
		this.href = href;
		this.name = name;
	}
	
	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
