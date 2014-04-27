package com.ideaiselectronics.catalogo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartDaoBehavior;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Service
public class ShoppingCartJSONDao extends AbstractDao implements ShoppingCartDaoBehavior {

	@Autowired
	@Qualifier("checkoutUrlCart")
	private String checkoutUrlCart;

	@Override
	public boolean addToShoppingCart(Long itemId) {
		return restClient.post(checkoutUrlCart + "addItemToCart", JsonUtil.writeObjectToJson(String.valueOf(itemId)));
	}

}
