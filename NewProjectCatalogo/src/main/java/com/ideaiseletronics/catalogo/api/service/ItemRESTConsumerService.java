package com.ideaiseletronics.catalogo.api.service;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.api.service.interfaces.ClientMethods;
import com.ideaiseletronics.catalogo.api.service.interfaces.GenericConsumerService;
import com.ideaiseletronics.stock.domain.Item;

@Service
public class ItemRESTConsumerService implements GenericConsumerService<Item>{
	
	@Autowired
	private String stockURLItem;
	@Autowired
	private ClientMethods restClient;

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list() {
		return (List<Item>) restClient.get(stockURLItem, new GenericType< List<Item> >() {});
	}

	@Override
	public Item findById(Long id) {
		return (Item) restClient.get(stockURLItem + id, new GenericType<Item>() {});
	}
	
	public void setRestClient(RESTClient restClient) {
		this.restClient = restClient;
	}

}
