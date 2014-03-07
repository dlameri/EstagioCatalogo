package com.ideaiseletronics.catalogo.api.rest.service;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.api.rest.util.RESTClient;
import com.ideaiseletronics.stock.domain.Product;

@Service
public class ProductRESTConsumerService implements GenericConsumerService<Product>{
	
	@Autowired
	private String stockURLProduct;
	@Autowired
	private ClientMethods restClient;

	@Override
	public List<Product> list() {
		return (List<Product>) restClient.get(stockURLProduct, new TypeReference< List<Product> >() {});
	}

	@Override
	public Product findById(Long id) {
		return (Product) restClient.get(stockURLProduct + id, new TypeReference<Product>() {});
	}
	
	public void setRestClient(RESTClient restClient) {
		this.restClient = restClient;
	}

}
