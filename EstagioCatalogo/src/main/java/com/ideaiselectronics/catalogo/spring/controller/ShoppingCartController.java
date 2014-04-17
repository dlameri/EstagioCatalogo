package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController {
	
	@Autowired @Qualifier("shoppingCartDao")
	private ShoppingCartBehavior shoppingCartDao;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addToShoppingCart(@RequestParam("itemId") Long itemId, HttpSession session){
		if(shoppingCartDao.addToCart(itemId)){
			return "redirect: ../"; //redirecionar para a pagina de sucesso
		}
		return "redirect: ../"; //redirecionar para a pagina de erro
	}
	
	@RequestMapping ( value = "/cartQuantity", method = RequestMethod.GET)
	public ModelAndView searchProduct() {
		ModelAndView view = getBaseView("../decorators/catalogo-theme");
		
		return view;
	}

}
