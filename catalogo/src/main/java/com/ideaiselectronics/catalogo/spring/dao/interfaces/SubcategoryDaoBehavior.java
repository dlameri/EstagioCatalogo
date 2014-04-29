package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;

public interface SubcategoryDaoBehavior {
	
	public List<SubcategoryJSON> list();
	
	public SubcategoryJSON findById(Long id);
	
	public List<ProductJSON> listProductsBySubcategory(Long subcategoryId);
	
}
