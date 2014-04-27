package com.ideaiselectronics.catalogo.spring.service.interfaces;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface ShoppingCartServiceBehavior {
	
	public final String CART_TOP_COOKIE = "CartTop";
	
	public Boolean hasCartTopCookie(HttpServletRequest request);
	
	public Cookie createCartTopCookie(String domain, String uri);
	
	public String getTotalQuantityItems(HttpServletRequest request);
	
	public Boolean addItemToShoppingCart(Long itemId);

}
