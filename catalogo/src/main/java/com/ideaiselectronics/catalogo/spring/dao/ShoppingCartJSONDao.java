package com.ideaiselectronics.catalogo.spring.dao;

/*import org.jboss.resteasy.util.GenericType;*/
import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Service
public class ShoppingCartJSONDao extends AbstractDao implements ShoppingCartBehavior {

	@Autowired
	@Qualifier("checkoutUrlCart")
	private String checkoutUrlCart;

	@Override
	public boolean addToCart(Long itemId) {
		return restClient.post(checkoutUrlCart + "addItemToCart", JsonUtil.writeObjectToJson(String.valueOf(itemId)));
	}

	@Override
	public String cartQtd() {
		return (String) restClient.get(checkoutUrlCart + "totalQuantity", new GenericType<String>(){});

	}

}
