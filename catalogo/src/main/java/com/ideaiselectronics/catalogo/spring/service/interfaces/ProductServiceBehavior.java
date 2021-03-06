package com.ideaiselectronics.catalogo.spring.service.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

public interface ProductServiceBehavior {
	
	public List<ProductJSON> listTopSellersProducts(Integer quantity);
	
	public List<ProductJSON> listTopSellersProductsByCategory(Long categoryId);
	
	public List<ProductJSON> listProductsByCategory(Long categoryId);
	
	public List<ProductJSON> listProductsBySubcategory(Long subcategoryId);
	
	public List<ProductJSON> listPaginatedProductsByCategory(Long categoryId, Integer firstResult, Integer maxResults);
	
	public List<ProductJSON> listPaginatedProductsBySubcategory(Long subcategoryId, Integer firstResult, Integer maxResults);
	
	public ProductJSON getProductWithAllPropertiesFilled(Long productId);
	
	public List<ProductJSON> search(String textToSearch);
	
	public List<ProductJSON> searchPaginatedProducts(String textToSearch, Integer firstResult, Integer maxResults);

	public List<ProductJSON> getPromoProducts();
	
	public Integer getTotalQuantityProductsByCategory(Long categoryId);

	public Integer getTotalQuantityProductsBySubcategory(Long subcategoryId);

	public Integer getTotalQuantityProductsFound(String productName);
}