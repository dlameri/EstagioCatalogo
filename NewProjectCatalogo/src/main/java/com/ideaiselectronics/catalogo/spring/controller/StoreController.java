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

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;

@Controller("storeController")
@RequestMapping("/")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StoreController {
	
	@Autowired @Qualifier("categoryDao")
	private CategoryDaoBehavior categoryDao;
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		ModelAndView view = new ModelAndView("catalogo/store");
		view.addObject("categories", categoryDao.list());
		view.addObject("products", productDao.list());
		
		return view;
    }
	
	/* Será que seria melhor colocar esse request num controller de categoria ou produto? */
	@RequestMapping( value="category/{idCategory}", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("idCategory") Long idCategory) {
		ModelAndView view = new ModelAndView("catalogo/itemsByCategory");
		view.addObject("category", categoryDao.findById(idCategory));
		view.addObject("products", productDao.findByCategoryId(idCategory));
		
		return view;
	}

}
