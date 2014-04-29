package com.ideaiselectronics.catalogo.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value="/{categoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("categoryId") Long categoryId, HttpServletRequest request, HttpServletResponse response ) {
		ModelAndView view = getBaseView( request, response, "catalogo/productsByCategory" );
		view.addObject( "category", categoryService.getCategoryWithSubcategories( categoryId ) );
		view.addObject( "products", productService.listProductsByCategory( categoryId ) );
		
		return view;
	}
	
	@RequestMapping( value="/{categoryId}/paginatedProduct", method = RequestMethod.GET )
	@ResponseBody
	public String productsByCategoryPaginated( @PathVariable("categoryId") Long categoryId, @RequestParam("maxResults") Integer maxResults, @RequestParam("firstResult") Integer firstResult, HttpServletRequest request, HttpServletResponse response ) {
		List<ProductJSON> products = productService.listPaginatedProducts( categoryId, firstResult, maxResults );
		return convertToJSON( products );
	}
	
	private String convertToJSON(List<ProductJSON> products) {
		String json = "";
		for (ProductJSON productJSON : products) {
			json = json.concat( JsonUtil.writeObjectToJson(productJSON) );
		}
		return json;
	}
	
}
