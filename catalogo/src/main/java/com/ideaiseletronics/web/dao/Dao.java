package com.ideaiseletronics.web.dao;

import java.util.List;

public interface Dao<T> {

	public void save(T obj);
	public T findById(Long id);
	public List<T> findAll();

}
