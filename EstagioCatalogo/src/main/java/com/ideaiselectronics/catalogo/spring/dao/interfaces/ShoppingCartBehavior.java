package com.ideaiselectronics.catalogo.spring.dao.interfaces;

public interface ShoppingCartBehavior {
	
	public boolean addToCart(Long itemId);
	
	public int cartQtd();

}
