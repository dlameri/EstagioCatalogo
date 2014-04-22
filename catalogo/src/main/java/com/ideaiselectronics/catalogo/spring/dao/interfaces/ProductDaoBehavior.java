package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

public interface ProductDaoBehavior {
	
	public ProductJSON findById(Long id);
	
	public List<ProductJSON> list();
	
	public List<ProductJSON> listOrderByRank(int quantity);
	
	public List<ItemJSON> listItems(Long productId);
	
	public List<ProductJSON> listTopSellersProducts(int quantity);
	
	public List<ProductJSON> findByCategoryId(Long categoryId);
	
	public List<ProductJSON> findBySubcategoryId(Long subcategoryId);
	
	public List<ProductJSON> findByName(String name);

}
