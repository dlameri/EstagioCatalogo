package com.ideaiseletronics.catalogo.api.rest.service;

import java.util.List;

public interface GenericConsumerService<T> {
	
	public List<T> list();
	
	public T findById(Long id);

}
