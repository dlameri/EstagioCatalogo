package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideaiselectronics.catalogo.spring.api.domain.checkout.Cart;
import com.ideaiselectronics.catalogo.spring.api.domain.checkout.CartItem;

@Controller
@RequestMapping("/shoppingCart")
//@SessionAttributes("shoppingCart")
public class ShoppingCartController {
	
	private static final String SHOPPING_CART = "cart";
	private static final Integer QUANTITY_DEFAULT= 1;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addToShoppingCart(@RequestParam("itemId") Long itemId, HttpSession session){
		Cart cart = takeCartFromSession(session);
		cart.addStockItem(new CartItem(itemId, QUANTITY_DEFAULT));
		session.setAttribute(SHOPPING_CART, cart);
		return "redirect: ../"; //redirecionar para a pagina anterior ao item selecionado?
	}
	
	private boolean haveAddedItemsToTheShoppingCart(HttpSession session) {
		return session.getAttribute(SHOPPING_CART)!=null;
	}
	
	private Cart takeCartFromSession(HttpSession session) {
		if(haveAddedItemsToTheShoppingCart(session)){
			return new Cart();
		}
		return (Cart) session.getAttribute(SHOPPING_CART);
	}

}
