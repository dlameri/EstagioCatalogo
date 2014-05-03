package com.ideaiselectronics.catalogo.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;
import com.ideaiselectronics.catalogo.spring.service.interfaces.SubcategoryServiceBehavior;

@Controller("subcategoryController")
@RequestMapping("/subcategory")
public class SubcategoryController extends BaseController {
	
	@Autowired @Qualifier("subcategoryService")
	private SubcategoryServiceBehavior subcategoryService;
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value="/{subcategoryId}/product", method = RequestMethod.GET )
	public void productsBySubcategory( @PathVariable("subcategoryId") Long subcategoryId, HttpServletRequest request, HttpServletResponse response  ){
		try {
			SubcategoryJSON subcategory = subcategoryService.getSubcategory( subcategoryId );
			request.setAttribute( "subcategorySelected", subcategory );
			request.getRequestDispatcher("/category/" + subcategory.getCategoryId() + "/product").forward( request, response );
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

}
