package com.ideaiseletronics.catalogo.api.service.interfaces;

import java.util.List;

public interface GenericConsumerService<T> {
	
	public List<T> list();
	
	public T findById(Long id);

}
