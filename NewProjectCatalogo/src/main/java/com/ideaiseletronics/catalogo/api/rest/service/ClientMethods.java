package com.ideaiseletronics.catalogo.api.rest.service;

import org.codehaus.jackson.type.TypeReference;

public interface ClientMethods {
	
	public <T> Object get(String url, TypeReference<T> type);
	
	public void post(String url);
	
	public void put(String url);
	
	public void options();

}
