package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;

@Controller("productController")
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	
	@RequestMapping( value="/{productId}", method = RequestMethod.GET )
	public ModelAndView showProductDetails( @PathVariable("productId") Long productId ) {
		ModelAndView view = getBaseView("catalogo/productDetails");
		view.addObject("product", productDao.findById(productId));
		
		return view;
	}
	
	@RequestMapping ( value = "/search", method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam(value="name", required=false) String productName ) {
		ModelAndView view = getBaseView("catalogo/productSearch");
		
		// isso aqui não retorna uma lista de produtos não?
		view.addObject("product", productDao.findByName(productName));
		
		return view;
	}

}
