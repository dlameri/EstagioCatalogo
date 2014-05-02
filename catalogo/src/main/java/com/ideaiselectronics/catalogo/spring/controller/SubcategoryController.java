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
import com.ideaiselectronics.catalogo.spring.service.interfaces.SubcategoryServiceBehavior;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Controller("subcategoryController")
@RequestMapping("/subcategory")
public class SubcategoryController extends BaseController {
	
	@Autowired @Qualifier("subcategoryService")
	private SubcategoryServiceBehavior subcategoryService;
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
	@RequestMapping( value="/{subcategoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsBySubcategory( @PathVariable("subcategoryId") Long subcategoryId, HttpServletRequest request, HttpServletResponse response  ){
		ModelAndView view = getBaseView( request, response, "catalogo/productsBySubcategory" );
		view.addObject( "subcategory", subcategoryService.getSubcategory( subcategoryId ) );
		view.addObject( "products", productService.listProductsBySubcategory( subcategoryId ) );
			
		return view;
	}
	
	// acho q isso aqui deveria estar na parte de servicos do catalogo, na parte de api.
	@RequestMapping( value="/{subcategoryId}/product/totalCounted", method = RequestMethod.GET )
	@ResponseBody
	public String getTotalQuantityProductsBySubcategory( @PathVariable("subcategoryId") Long subcategoryId ) {
		Integer countedProducts = productService.getTotalQuantityProductsBySubcategory( subcategoryId );
		return JsonUtil.writeObjectToJson( countedProducts );
	}
	
	@RequestMapping( value="/{subcategoryId}/paginatedProduct", method = RequestMethod.GET )
	@ResponseBody
	public String productsBySubcategoryPaginated( @PathVariable("subcategoryId") Long subcategoryId, @RequestParam("maxResults") Integer maxResults, @RequestParam("firstResult") Integer firstResult ) {
		List<ProductJSON> products = productService.listPaginatedProductsBySubcategory( subcategoryId, firstResult, maxResults );		
		return JsonUtil.writeObjectToJson( products );
	}
	

}
