package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.service.interfaces.CategoryServiceBehavior;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ShoppingCartServiceBehavior;

@Component
public abstract class BaseController {
	
	@Autowired
	protected String applicationDomain;
	@Autowired
	protected String applicationRootPath;
	
	@Autowired @Qualifier("categoryService")
	protected CategoryServiceBehavior categoryService;
	@Autowired @Qualifier("shoppingCartService")
	protected ShoppingCartServiceBehavior shoppingCartService;
	
	protected static final Integer INICIAL_QUANTITY_ITEM = 0;
	
	public BaseController() {
		
	}
	
	public ModelAndView getBaseView( HttpServletRequest request, HttpServletResponse response, String pageName ) {
		ModelAndView view = new ModelAndView( pageName );
		view.addObject( "menuCategories", categoryService.listCategoriesWithSubcategories() );
		
		addCartTopCookie( request, response, view );
		
		return view;
	}

	private void addCartTopCookie( HttpServletRequest request, HttpServletResponse response, ModelAndView view ) {
		if( !shoppingCartService.hasCartTopCookie( request ) ) {
			response.addCookie( shoppingCartService.createCartTopCookie( applicationDomain, applicationRootPath ) );
			view.addObject( "cartItemsQuantity", INICIAL_QUANTITY_ITEM );
			return;
		}
		view.addObject( "cartItemsQuantity", shoppingCartService.getTotalQuantityItems( request ) );
	}

}
