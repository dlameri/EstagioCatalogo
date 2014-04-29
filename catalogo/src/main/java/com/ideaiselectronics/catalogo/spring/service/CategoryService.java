package com.ideaiselectronics.catalogo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.CategoryJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.CategoryServiceBehavior;

@Service
public class CategoryService implements CategoryServiceBehavior {
	
	@Autowired @Qualifier("categoryJSONDao")
	protected CategoryDaoBehavior categoryDao;

	@Override
	public List<CategoryJSON> listCategoriesWithSubcategories() {
		List<CategoryJSON> categoriesJSON = categoryDao.list();
		if ( categoriesJSON != null ){
			for (CategoryJSON categoryJSON : categoriesJSON) {
				categoryJSON.setSubcategories( categoryDao.listSubcategories( categoryJSON.getId() ) );
			}
		}
		return categoriesJSON;
	}

	@Override
	public CategoryJSON getCategoryWithSubcategories( Long categoryId ) {
		CategoryJSON category = categoryDao.findById( categoryId );
		category.setSubcategories( categoryDao.listSubcategories( category.getId() ) );
		return category;
	}
	
}
