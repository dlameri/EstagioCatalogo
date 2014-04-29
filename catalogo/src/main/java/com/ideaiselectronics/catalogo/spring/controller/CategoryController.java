package com.ideaiselectronics.catalogo.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;

@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value="/{categoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("categoryId") Long categoryId, HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView view = getBaseView( request, response, "catalogo/productsByCategory" );
		view.addObject( "category", categoryService.getCategoryWithSubcategories( categoryId ) );
		view.addObject( "products", productService.listProductsByCategory( categoryId ) );
		
		return view;
	}
	
}
