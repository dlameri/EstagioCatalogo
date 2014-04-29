package com.ideaiselectronics.catalogo.spring.service.interfaces;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShoppingCartServiceBehavior {
	
	public final String CART_TOP_COOKIE = "CartTop";
	
	public Boolean hasCartTopCookie(HttpServletRequest request);
	
	public Cookie createCartTopCookie(String domain, String uri);
	
	public String getTotalQuantityItems(HttpServletRequest request);
	
	public void addItemToShoppingCart(HttpServletResponse response, Long itemId) throws IOException;

	public void redirectToCheckoutShoppingCart(HttpServletResponse response) throws IOException;

}
