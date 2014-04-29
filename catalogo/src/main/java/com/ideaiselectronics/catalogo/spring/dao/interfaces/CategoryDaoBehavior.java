package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.CategoryJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;

public interface CategoryDaoBehavior {
	
	public List<CategoryJSON> list();
	
	public CategoryJSON findById(Long id);
	
	public List<SubcategoryJSON> listSubcategories(Long categoryId);
	
	public List<ProductJSON> listProductsByCategory(Long categoryId);
	
	public List<ProductJSON> listTopSellersProducts(Long categoryId);

}
