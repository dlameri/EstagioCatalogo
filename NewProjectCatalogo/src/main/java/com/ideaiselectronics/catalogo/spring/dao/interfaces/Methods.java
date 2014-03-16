package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import javax.ws.rs.core.GenericType;

public interface Methods {
	
	public <T> Object get(String url, GenericType<T> type);
	
	public void post(String url);
	
	public void put(String url);
	
	public void options();

}
