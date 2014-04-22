package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;

@Controller("shoppingCart")
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController {
	
	@Autowired @Qualifier("shoppingCartJSONDao")
	private ShoppingCartBehavior shoppingCartJSONDao;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addToShoppingCart(@RequestParam("itemId") Long itemId){
		if(shoppingCartJSONDao.addToCart(itemId)){
			return "redirect: ../"; //redirecionar para a pagina de sucesso
		}
		return "redirect: ../"; //redirecionar para a pagina de erro
	}
	

}
