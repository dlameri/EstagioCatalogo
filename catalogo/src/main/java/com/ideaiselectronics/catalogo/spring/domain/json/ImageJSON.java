package com.ideaiselectronics.catalogo.spring.domain.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageJSON {
	
	private Long id;
	private String showcaseUrl;
	private String promo;
	private String productUrl;
	private String superzoomUrl;
	private String shoppingCartUrl;
	private String androidShowcaseUrl;
	private String androidProductUrl;
	private Boolean main;
	
	public ImageJSON() {

	}

	public ImageJSON(String defaultUrl) {
		productUrl = defaultUrl;
		showcaseUrl = defaultUrl;
		promo = defaultUrl;
		productUrl = defaultUrl;
		superzoomUrl = defaultUrl;
		shoppingCartUrl = defaultUrl;
		androidShowcaseUrl = defaultUrl;
		androidProductUrl = defaultUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowcaseUrl() {
		return showcaseUrl;
	}

	public void setShowcaseUrl(String showcaseUrl) {
		this.showcaseUrl = showcaseUrl;
	}
	
	public String getPromo() {
		return promo;
	}
	
	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getSuperzoomUrl() {
		return superzoomUrl;
	}

	public void setSuperzoomUrl(String superzoomUrl) {
		this.superzoomUrl = superzoomUrl;
	}

	public String getShoppingCartUrl() {
		return shoppingCartUrl;
	}

	public void setShoppingCartUrl(String shoppingCartUrl) {
		this.shoppingCartUrl = shoppingCartUrl;
	}

	public String getAndroidShowcaseUrl() {
		return androidShowcaseUrl;
	}

	public void setAndroidShowcaseUrl(String androidShowcaseUrl) {
		this.androidShowcaseUrl = androidShowcaseUrl;
	}

	public String getAndroidProductUrl() {
		return androidProductUrl;
	}

	public void setAndroidProductUrl(String androidProductUrl) {
		this.androidProductUrl = androidProductUrl;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}
	
}
