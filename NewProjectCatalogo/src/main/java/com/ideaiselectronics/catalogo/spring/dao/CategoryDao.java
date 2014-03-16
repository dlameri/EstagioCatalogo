package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.Category;

@Service
public class CategoryDao extends AbstractDao implements CategoryDaoBehavior{

	@Autowired
	private String stockUrlCategory;
	
	@Override
	public Category findById(Long id) {
		return (Category) restClient.get(stockUrlCategory + id, new GenericType<Category>() {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		return (List<Category>) restClient.get(stockUrlCategory, new GenericType< List<Category> >() {});
	}

}
