package com.ideaiseletronics.web.domain;

public class Image {

	private Long id;
	private String showcaseUrl;
	private String productUrl;
	private String superzoomUrl;
	private String shoppingCartUrl;
	private String androidShowcaseUrl;
	private String androidProductUrl;
	private Boolean main;
	private Product product;

	public Image() {
		
	}

	public Image(Long id, String showcaseUrl, String productUrl,
			String superzoomUrl, String shoppingCartUrl,
			String androidShowcaseUrl, String androidProductUrl, Boolean main,
			Product product) {
		this.id = id;
		this.showcaseUrl = showcaseUrl;
		this.productUrl = productUrl;
		this.superzoomUrl = superzoomUrl;
		this.shoppingCartUrl = shoppingCartUrl;
		this.androidShowcaseUrl = androidShowcaseUrl;
		this.androidProductUrl = androidProductUrl;
		this.main = main;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public String getShowcaseUrl() {
		return showcaseUrl;
	}

	public Boolean getMain() {
		return main;
	}

	public Product getProduct() {
		return product;
	}
	
}