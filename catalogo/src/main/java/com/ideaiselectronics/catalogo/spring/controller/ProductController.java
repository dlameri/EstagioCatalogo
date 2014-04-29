package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;

@Controller("productController")
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value = "/{productId}", method = RequestMethod.GET )
	public ModelAndView showProductDetails( @PathVariable("productId") Long productId, HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView view = getBaseView( request, response, "catalogo/productDetails" );
		view.addObject("product", productService.getProductWithAllPropertiesFilled( productId ) );
		
		return view;
	}

	@RequestMapping( value = "/search", method = RequestMethod.GET )
	public ModelAndView searchProduct( @RequestParam(value = "productName", required = false) String productName, HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView view = getBaseView( request, response, "catalogo/productSearch" );
		view.addObject( "products", productService.search( productName ) );
		
		return view;
	}

}
