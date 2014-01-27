package com.ideaiseletronics.web.domain;

public class ShoppingCartLine {

	private Long id;
	private Product product;
	private Integer quantity;
	private Double price;
	private ShoppingCart shoppingCart;
	
	public ShoppingCartLine() {
		
	}
	
	public ShoppingCartLine(Long id, Product product, Integer quantity,
			Double price, ShoppingCart shoppingCart) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.shoppingCart = shoppingCart;
	}

	public Long getId() {
		return id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity( Integer quantity ) throws Exception {
		if ( quantity >= 0 ) {
			this.quantity = quantity;
		} else {
			throw new Exception("Number not supported!");
		}
	}
	
	public Double getPrice() {
		return price;
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public Double calculatePrice() {
		return product.getPriceFor() * quantity;
	}
	
	public void increaseByOne() {
		quantity++;
	}
	
	public void decreaseByOne() {
		if (quantity > 0) {
			quantity--;
		}
	}
	
}