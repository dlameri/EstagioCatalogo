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

@Controller("subcategoryController")
@RequestMapping("/subcategory")
public class SubcategoryController extends BaseController {
	
	@Autowired @Qualifier("subcategoryJSONDao")
	private SubcategoryDaoBehavior subcategoryJSONDao;
	@Autowired @Qualifier("productJSONDao")
	private ProductDaoBehavior productJSONDao;
	
	@RequestMapping( value="/{subcategoryId}/product", method = RequestMethod.GET)
	public ModelAndView productsBySubcategory(@PathVariable("subcategoryId") Long subcategoryId){
		ModelAndView view = getBaseView("catalogo/productsBySubcategory");
		view.addObject("subcategory", subcategoryJSONDao.findById(subcategoryId));
		view.addObject("products", productJSONDao.findBySubcategoryId(subcategoryId));
			
		return view;
	}
	

}
