package com.ideaiseletronics.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ideaiseletronics.web.domain.Product;
import com.ideaiseletronics.web.domain.ShoppingCart;
import com.ideaiseletronics.web.domain.ShoppingCartLine;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private ShoppingCart shoppingCart;
	private Product product;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		this.shoppingCart = ( ShoppingCart ) session.get("shoppingCart");
	}
	
	public String addItem() {
		if( this.shoppingCart == null ) {
			shoppingCart = new ShoppingCart();
			this.session.put("shoppingCart", shoppingCart );
		}
		
		shoppingCart.add(new ShoppingCartLine( null, product, 0, product.getPriceFor(), shoppingCart) );
		
		return SUCCESS;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct( Product product ) {
		this.product = product;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

}