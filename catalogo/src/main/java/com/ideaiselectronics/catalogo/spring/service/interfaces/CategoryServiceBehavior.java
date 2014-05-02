package com.ideaiselectronics.catalogo.spring.service.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.CategoryJSON;

public interface CategoryServiceBehavior {
	
	public List<CategoryJSON> listCategoriesWithSubcategories();
	
	public CategoryJSON getCategoryWithSubcategories(Long categoryId);
	
	public CategoryJSON getCategory(Long categoryId);

}