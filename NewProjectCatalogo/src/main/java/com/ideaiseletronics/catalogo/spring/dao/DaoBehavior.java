package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

public interface DaoBehavior<T> {

	public Long save(T object);
	
	public void update(T object);
	
	public void delete(T object);
	
	public List<T> findAll(Class<? extends Object> clazz);
	
	public T findById(Class<? extends Object> clazz, Long id);

}
