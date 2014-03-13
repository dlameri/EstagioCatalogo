package com.ideaiseletronics.catalogo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ideaiseletronics.catalogo.spring.dao.interfaces.Methods;

@Component
public abstract class AbstractDao {
	
	@Autowired
	protected String urlAccess;
	@Autowired
	protected Methods restClient;
	
	
	protected abstract void setUrlAccess();

}
