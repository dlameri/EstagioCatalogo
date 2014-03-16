package com.ideaiselectronics.catalogo.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.GenericDao;
import com.ideaiselectronics.catalogo.spring.domain.Category;
import com.ideaiselectronics.catalogo.spring.domain.Product;

@Controller("StoreController")
@RequestMapping("/")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StoreController {
	
	@Autowired @Qualifier("categoryDao")
	private GenericDao<Category> categoryDao;
	@Autowired @Qualifier("productDao")
	private GenericDao<Product> productDao;
	private Map< String, List<?> > modelsToDisplayInShowcase = new HashMap< String, List<?> >();
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		getStoreCategories();
		getStoreProducts();
		
		return new ModelAndView("catalogo/store", modelsToDisplayInShowcase);
    }
	
	private void getStoreCategories() {
		modelsToDisplayInShowcase.put("categories", categoryDao.list() );
	}
	
	private void getStoreProducts() {
		modelsToDisplayInShowcase.put("products", productDao.list());
	}

}
