package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;

@Controller("productController")
@RequestMapping("/product")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductController {
	
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	
	@RequestMapping( value="/{idProduct}", method = RequestMethod.GET )
	public ModelAndView showProductDetails( @PathVariable("idProduct") Long idProduct) {
		return new ModelAndView("catalogo/productDetails", "product", productDao.findById(idProduct));
	}

}
