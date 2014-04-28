package com.ideaiselectronics.catalogo.spring.service;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartDaoBehavior;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ShoppingCartServiceBehavior;

@Service
public class ShoppingCartService  implements ShoppingCartServiceBehavior {
	
	@Autowired @Qualifier("shoppingCartJSONDao")
	private ShoppingCartDaoBehavior shoppingCartDao;
	private final String ADD_ITEM_CHECKOUT = "http://ideaiselectronics.com:9082/Checkout/shoppingcart/codItem/"; 

	@Override
	public Boolean hasCartTopCookie( HttpServletRequest request ) {
		return request.getCookies() != null && getCookieByName( request.getCookies(), ShoppingCartServiceBehavior.CART_TOP_COOKIE ) != null;
	}

	@Override
	public Cookie createCartTopCookie( String domain, String uri ) {
		Cookie cartTop = new Cookie( CART_TOP_COOKIE, "0" );
		cartTop.setDomain( domain );
		cartTop.setPath( uri );
		return cartTop;
	}
	
	@Override
	public String getTotalQuantityItems( HttpServletRequest request ) {
		Cookie cartTop = getCookieByName( request.getCookies(), ShoppingCartServiceBehavior.CART_TOP_COOKIE );
		return cartTop.getValue();
	}
	
	@Override
	public void addItemToShoppingCart( HttpServletResponse response, Long itemId ) throws IOException {
		response.sendRedirect( ADD_ITEM_CHECKOUT + itemId );
	}
	
	private Cookie getCookieByName( Cookie[] cookies, String name ) {
		for (int i = 0; i < cookies.length; i++) {
			if( cookies[i].getName().equals( ShoppingCartServiceBehavior.CART_TOP_COOKIE ) ) {
				return cookies[i];
			}
		}
		return null;
	}
	
}
