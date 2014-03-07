package com.ideaiseletronics.catalogo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.spring.dao.CategoryDao;
import com.ideaiseletronics.stock.domain.Category;

@Service
public class CategoryService implements GenericService<Category> {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Long create(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public List<Category> list() {
		return categoryDao.findAll(Category.class);
	}

	@Override
	public Category findById(Long id) {
		return categoryDao.findById(Category.class, id);
	}
	
	/* GETTERS AND SETTERS */
	public void setCategoryDao( CategoryDao categoryDao ) {
		this.categoryDao = categoryDao;
	}

}
