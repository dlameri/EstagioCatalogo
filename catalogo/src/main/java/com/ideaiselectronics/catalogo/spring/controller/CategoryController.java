package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;

@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	@Autowired @Qualifier("subcategoryDao")
	private SubcategoryDaoBehavior subcategoryDao;
	
	@RequestMapping( value="/{categoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("categoryId") Long categoryId) {
		ModelAndView view = getBaseView("catalogo/productsByCategory");
		view.addObject("category", categoryDao.findById(categoryId));
		view.addObject("products", productDao.findByCategoryId(categoryId));
		
		return view;
	}
	
	@RequestMapping( value="/subcategory/{idSubcategory}/product", method = RequestMethod.GET)
	public ModelAndView productsBySubcategory(@PathVariable("idSubcategory") Long subcategoryId){
		ModelAndView view = getBaseView("catalogo/productsBySubcategory");
		view.addObject("subcategory", subcategoryDao.findById(subcategoryId));
		view.addObject("products", productDao.findBySubcategoryId(subcategoryId));
			
		return view;
	}

}
