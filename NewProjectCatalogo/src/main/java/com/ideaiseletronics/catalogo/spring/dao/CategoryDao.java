package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.spring.dao.interfaces.GenericDao;
import com.ideaiseletronics.catalogo.spring.domain.Category;

@Service
public class CategoryDao extends AbstractDao implements GenericDao<Category> {

	@Autowired
	private String stockUrlCategory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		return (List<Category>) restClient.get(stockUrlCategory, new GenericType< List<Category> >() {});
	}

	@Override
	public Category findById(Long id) {
		return (Category) restClient.get(stockUrlCategory + id, new GenericType<Category>() {});
	}

}
