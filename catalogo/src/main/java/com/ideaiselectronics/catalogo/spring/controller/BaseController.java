package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;

@Component
public abstract class BaseController {
	
	@Autowired @Qualifier("categoryDao")
	protected CategoryDaoBehavior categoryDao;
	@Autowired @Qualifier("shoppingCartDao")
	protected ShoppingCartBehavior shoppingCartDao;
	
	public BaseController() {
		
	}
	
	public ModelAndView getBaseView(String pageName) {
		ModelAndView view = new ModelAndView(pageName);
		view.addObject("categories", categoryDao.list());
		view.addObject("cart", shoppingCartDao.cartQtd());
		return view;
	}

}
