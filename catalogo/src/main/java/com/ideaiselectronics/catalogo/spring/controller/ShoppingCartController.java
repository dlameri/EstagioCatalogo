package com.ideaiselectronics.catalogo.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideaiselectronics.catalogo.spring.service.interfaces.ShoppingCartServiceBehavior;

@Controller("shoppingCart")
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController {
	
	@Autowired @Qualifier("shoppingCartService")
	private ShoppingCartServiceBehavior shoppingCartService;
	
	@RequestMapping( value="/addItem", method = RequestMethod.POST )
	public void addToShoppingCart( @RequestParam("itemId") Long itemId, HttpServletRequest request, HttpServletResponse response ){
		try {
			shoppingCartService.addItemToShoppingCart( response, itemId );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
