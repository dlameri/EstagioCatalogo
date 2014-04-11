package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.Subcategory;

public interface SubcategoryDaoBehavior {
	public Subcategory findById(Long id);

	public List<Subcategory> list();
}
