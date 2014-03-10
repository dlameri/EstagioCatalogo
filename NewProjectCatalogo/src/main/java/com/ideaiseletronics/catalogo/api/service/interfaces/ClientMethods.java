package com.ideaiseletronics.catalogo.api.service.interfaces;

import javax.ws.rs.core.GenericType;

public interface ClientMethods {
	
	public <T> Object get(String url, GenericType<T> type);
	
	public void post(String url);
	
	public void put(String url);
	
	public void options();

}
