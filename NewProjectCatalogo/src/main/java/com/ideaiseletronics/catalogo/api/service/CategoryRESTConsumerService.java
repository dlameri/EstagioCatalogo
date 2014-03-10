package com.ideaiseletronics.catalogo.api.service;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.api.service.interfaces.ClientMethods;
import com.ideaiseletronics.catalogo.api.service.interfaces.GenericConsumerService;
import com.ideaiseletronics.stock.domain.Category;

@Service
public class CategoryRESTConsumerService implements GenericConsumerService<Category> {
	
	@Autowired
	private String stockURLCategory;
	@Autowired
	private ClientMethods restClient;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		return (List<Category>) restClient.get(stockURLCategory, new GenericType< List<Category> >() {});
	}

	@Override
	public Category findById(Long id) {
		return (Category) restClient.get(stockURLCategory + id, new GenericType<Category>() {});
	}	

}
