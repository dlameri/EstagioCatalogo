package com.ideaiseletronics.catalogo.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiseletronics.catalogo.api.rest.service.CategoryRESTConsumerService;
import com.ideaiseletronics.catalogo.api.rest.service.GenericConsumerService;
import com.ideaiseletronics.catalogo.api.rest.service.ProductRESTConsumerService;
import com.ideaiseletronics.stock.domain.Category;
import com.ideaiseletronics.stock.domain.Product;

@Controller("ShowcaseController")
@RequestMapping("/")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ShowcaseController {
	
	@Autowired
	private GenericConsumerService<Category> categoryRESTConsumer;
	@Autowired
	private GenericConsumerService<Product> productRESTConsumer; 
	private Map< String, List<?> > modelsToDisplayInShowcase = new HashMap< String, List<?> >();
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		getStoreCategories();
		getStoreProducts();
		
		return new ModelAndView("catalogo/showcase", modelsToDisplayInShowcase);
    }
	
	private void getStoreCategories() {
		modelsToDisplayInShowcase.put("categories", categoryRESTConsumer.list() );
	}
	
	private void getStoreProducts() {
		modelsToDisplayInShowcase.put("products", productRESTConsumer.list());
	}
	
	/* GETTERS AND SETTERS */
	public void setCategoryConsumer(CategoryRESTConsumerService categoryConsumer) {
		this.categoryRESTConsumer = categoryConsumer;
	}
	public void setProductRESTConsumer(ProductRESTConsumerService productRESTConsumer) {
		this.productRESTConsumer = productRESTConsumer;
	}

}
