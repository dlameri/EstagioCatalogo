package com.ideaiseletronics.catalogo.api.rest.service;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.api.rest.util.RESTClient;
import com.ideaiseletronics.stock.domain.Category;

@Service
public class CategoryRESTConsumerService implements GenericConsumerService<Category> {
	
	@Autowired
	private String stockURLCategory;
	@Autowired
	private ClientMethods restClient;

	@Override
	public List<Category> list() {
		return (List<Category>) restClient.get(stockURLCategory, new TypeReference< List<Category> >() {});
	}

	@Override
	public Category findById(Long id) {
		return (Category) restClient.get(stockURLCategory + id, new TypeReference<Category>() {});
	}
	
	public void setRestClient(RESTClient restClient) {
		this.restClient = restClient;
	}
	

}
