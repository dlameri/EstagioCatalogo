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
import com.ideaiselectronics.catalogo.spring.service.interfaces.SubcategoryServiceBehavior;

@Controller("subcategoryController")
@RequestMapping("/subcategory")
public class SubcategoryController extends BaseController {
	
	@Autowired @Qualifier("subcategoryService")
	private SubcategoryServiceBehavior subcategoryService;
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value="/{subcategoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsBySubcategory( @PathVariable("subcategoryId") Long subcategoryId, HttpServletRequest request, HttpServletResponse response  ){
		ModelAndView view = getBaseView( request, response, "catalogo/productsBySubcategory" );
		view.addObject( "subcategory", subcategoryService.getSubcategory( subcategoryId ) );
		view.addObject( "products", productService.listProductsBySubcategory( subcategoryId ) );
			
		return view;
	}
	

}
