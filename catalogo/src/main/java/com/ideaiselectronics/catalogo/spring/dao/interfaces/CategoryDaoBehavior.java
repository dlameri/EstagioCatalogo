package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.Category;

public interface CategoryDaoBehavior {
	
	public Category findById(Long id);
	
	public List<Category> list();

}
