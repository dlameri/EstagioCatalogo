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
@RequestMapping("/api/subcategory")
public class SubcategoryApi {
	
	@Autowired @Qualifier("productService")
	private ProductServiceBehavior productService;
	
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
