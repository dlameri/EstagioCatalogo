package com.ideaiseletronics.catalogo.spring.service;

import java.util.List;

public interface GenericService<T> {

	public Long create(T object);
	
	public void update(T object);
	
	public void delete(T object);
	
	public List<T> list();
	
	public T findById(Long id);

}
