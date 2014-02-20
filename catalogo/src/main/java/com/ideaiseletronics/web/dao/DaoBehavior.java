package com.ideaiseletronics.web.dao;

import java.util.List;

public interface DaoBehavior<T> {

	public Long save(T obj);
	
	public T findById(Long id);
	
	public List<T> findAll();
	
	public void delete(T obj);

}
