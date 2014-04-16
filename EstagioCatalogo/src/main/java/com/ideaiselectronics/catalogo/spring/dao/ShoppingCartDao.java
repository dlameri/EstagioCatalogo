package com.ideaiselectronics.catalogo.spring.dao;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;
import com.ideaiselectronics.catalogo.spring.domain.Item;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Service
public class ShoppingCartDao extends AbstractDao implements ShoppingCartBehavior {
	
	@Autowired @Qualifier("checkoutUrlCart")
	private String checkoutUrlCart; 

	@Override
	public boolean addToCart(Long itemId) {
		return restClient.post(checkoutUrlCart + "addItemToCart", JsonUtil.writeObjectToJson( String.valueOf(itemId) ));
	}

	@Override
	public int cartQtd() {
		return (Integer) restClient.get(checkoutUrlCart + "totalQuantity", new GenericType<Item>() {});
		
	}



	
}
