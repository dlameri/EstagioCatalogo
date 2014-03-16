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

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;

@Controller("itemController")
@RequestMapping("/item")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ItemController {
	
	@Autowired @Qualifier("itemDao")
	private ItemDaoBehavior itemDao;
	
	@RequestMapping( value="/{idItem}", method = RequestMethod.GET )
	public ModelAndView showItemDetails( @PathVariable("idItem") Long idItem) {
		return new ModelAndView("catalogo/itemDetails", "item", itemDao.findById(idItem));
	}

}
