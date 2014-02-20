package com.ideaiseletronics.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ideaiseletronics.web.domain.Item;
import com.ideaiseletronics.web.domain.ShoppingCart;
import com.ideaiseletronics.web.domain.ShoppingCartLine;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private ShoppingCart shoppingCart;
	private Item item;

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
		
		shoppingCart.add(new ShoppingCartLine( null, item, 0, item.getPriceFor(), shoppingCart) );
		
		return SUCCESS;
	}

	public Item getItem() {
		return item;
	}

	public void setItem( Item item ) {
		this.item = item;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

}