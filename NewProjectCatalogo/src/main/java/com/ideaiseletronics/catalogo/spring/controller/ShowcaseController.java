package com.ideaiseletronics.catalogo.spring.controller;

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

import com.ideaiseletronics.catalogo.api.service.interfaces.GenericConsumerService;
import com.ideaiseletronics.stock.domain.Category;
import com.ideaiseletronics.stock.domain.Item;

@Controller("ShowcaseController")
@RequestMapping("/")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ShowcaseController {
	
	@Autowired @Qualifier("categoryRESTConsumerService")
	private GenericConsumerService<Category> categoryRESTConsumer;
	@Autowired @Qualifier("itemRESTConsumerService")
	private GenericConsumerService<Item> itemRESTConsumer; 
	private Map< String, List<?> > modelsToDisplayInShowcase = new HashMap< String, List<?> >();
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		getStoreCategories();
		getStoreItens();
		
		return new ModelAndView("catalogo/showcase", modelsToDisplayInShowcase);
    }
	
	private void getStoreCategories() {
		modelsToDisplayInShowcase.put("categories", categoryRESTConsumer.list() );
	}
	
	private void getStoreItens() {
		modelsToDisplayInShowcase.put("itens", itemRESTConsumer.list());
	}

}
