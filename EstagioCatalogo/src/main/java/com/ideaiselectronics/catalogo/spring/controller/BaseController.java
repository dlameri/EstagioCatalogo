package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;

@Component
public abstract class BaseController {
	
	@Autowired @Qualifier("categoryDao")
	protected CategoryDaoBehavior categoryDao;
	
	public BaseController() {
		
	}
	
	public ModelAndView getBaseView(String pageName) {
		return new ModelAndView(pageName).addObject("categories", categoryDao.list());
	}

}
