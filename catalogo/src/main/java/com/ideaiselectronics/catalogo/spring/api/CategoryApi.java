package com.ideaiselectronics.catalogo.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;
import com.ideaiselectronics.catalogo.util.JsonUtil;

@Service
@RequestMapping("/api/category")
public class CategoryApi {
	
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;

	@RequestMapping( value="/{categoryId}/paginatedProduct", method = RequestMethod.GET )
	@ResponseBody
	public String productsByCategoryPaginated( @PathVariable("categoryId") Long categoryId, @RequestParam("maxResults") Integer maxResults, @RequestParam("firstResult") Integer firstResult ) {
		List<ProductJSON> products = productService.listPaginatedProductsByCategory( categoryId, firstResult, maxResults );		
		return JsonUtil.writeObjectToJson( products );
	}
	
}
