package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;
import java.util.Set;

import com.ideaiselectronics.catalogo.spring.domain.Product;

public interface ProductDaoBehavior {
	
	public Product findById(Long id);
	
	public List<Product> list();
	
	public List<Product> listOrderbyrank();
	
	public List<Product> findByCategoryId(Long idCategory);
	
	public List<Product> findBySubcategoryId(Long idSubcategory);

}
