package com.ideaiselectronics.catalogo.spring.service.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

public interface ProductServiceBehavior {
	
	public List<ProductJSON> listTopSellersProducts(Integer quantity);
	
	public List<ProductJSON> listTopSellersProductsByCategory(Long categoryId);
	
	public List<ProductJSON> listProductsByCategory(Long categoryId);
	
	public List<ProductJSON> listProductsBySubcategory(Long subcategoryId);
	
	public ProductJSON getProductWithAllPropertiesFilled(Long productId);
	
	public List<ProductJSON> search(String textToSearch);
}
