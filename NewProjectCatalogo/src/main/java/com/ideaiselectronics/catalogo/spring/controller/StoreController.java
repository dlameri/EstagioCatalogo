package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;

@Controller("storeController")
@RequestMapping("/")
public class StoreController {
	
	@Autowired @Qualifier("categoryDao")
	private CategoryDaoBehavior categoryDao;
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	@Autowired @Qualifier("subcategoryDao")
	private SubcategoryDaoBehavior subcategoryDao;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		ModelAndView view = new ModelAndView("catalogo/store");
		view.addObject("categories", categoryDao.list());
		view.addObject("products", productDao.listOrderByRank());
		
		return view;
    }
	
	@RequestMapping( value="category/{idCategory}", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("idCategory") Long idCategory) {
		ModelAndView view = new ModelAndView("catalogo/productsByCategory");
		view.addObject("category", categoryDao.findById(idCategory));
		view.addObject("products", productDao.findByCategoryId(idCategory));
	
		return view;
	}
	
	@RequestMapping( value="category/subcategory/{idSubcategory}", method = RequestMethod.GET)
	public ModelAndView productsBySubcategory(@PathVariable("idSubcategory") Long idSubcategory){
		ModelAndView view = new ModelAndView("catalogo/productsBySubcategory");
		view.addObject("subcategory", subcategoryDao.findById(idSubcategory));
		view.addObject("products", productDao.findBySubcategoryId(idSubcategory));
		
		return view;
	}
	

}
