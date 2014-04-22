package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ShoppingCartBehavior;

@Component
public abstract class BaseController {
	
	@Autowired @Qualifier("categoryJSONDao")
	protected CategoryDaoBehavior categoryJSONDao;
	@Autowired @Qualifier("shoppingCartJSONDao")
	protected ShoppingCartBehavior shoppingCartJSONDao;
	
	public BaseController() {
		
	}
	
	public ModelAndView getBaseView(String pageName) {
		ModelAndView view = new ModelAndView(pageName);
		view.addObject("menuCategories", categoryJSONDao.listCategoriesWithSubcategories());
		//view.addObject("cart", shoppingCartJSONDao.cartQtd());
		return view;
	}

}
