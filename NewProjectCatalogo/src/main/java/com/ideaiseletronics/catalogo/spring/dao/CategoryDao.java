package com.ideaiseletronics.catalogo.spring.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideaiseletronics.stock.domain.Category;

@Service
@Transactional
public class CategoryDao extends AbstractDao<Category> {
	
	public CategoryDao() {
		super();
	}

}
