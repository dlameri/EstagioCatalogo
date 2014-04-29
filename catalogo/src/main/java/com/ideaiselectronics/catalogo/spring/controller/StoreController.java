package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;

@Controller("storeController")
@RequestMapping("/")
public class StoreController extends BaseController {
	
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	private static final int TOP_SELLERS_QUANTITY = 10;
	private static final Long TOP_SELLERS_CATEGORY_ID_FIRST_SECTION = 1L;
	private static final Long TOP_SELLERS_CATEGORY_ID_SECOND_SECTION = 2L;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase( HttpServletResponse response, HttpServletRequest request ) {
		ModelAndView view = getBaseView( request, response, "catalogo/store" );
		view.addObject( "topSellersProducts", productService.listTopSellersProducts( TOP_SELLERS_QUANTITY ) );
		view.addObject( "topSellersProductsFirstSection", productService.listTopSellersProductsByCategory( TOP_SELLERS_CATEGORY_ID_FIRST_SECTION ) );
		view.addObject( "topSellersProductsSecondSection", productService.listTopSellersProductsByCategory( TOP_SELLERS_CATEGORY_ID_SECOND_SECTION ) );
		/*retornar do servico produtos em destaque!*/
		
		return view;
    }
	
}