package com.ideaiselectronics.catalogo.spring.api.domain.checkout;

import com.ideaiselectronics.catalogo.spring.domain.Item;

public class CartItem {
	private Long cartItemId;
	private Integer quantity;
	
	public CartItem(Long itemId, Integer quantity) {
		cartItemId = itemId;
		this.quantity = quantity;
	}
	
	public CartItem(Item item, Integer quantity) {
		cartItemId = item.getId();
		this.quantity = quantity;
	}
	
	public Long getCartItemId() {
		return cartItemId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
}