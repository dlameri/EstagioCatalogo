package com.ideaiseletronics.catalogo.spring.dao.interfaces;

import java.util.List;

public interface GenericDao<T> {
	
	public List<T> list();
	
	public T findById(Long id);

}
