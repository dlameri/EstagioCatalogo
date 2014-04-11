package com.ideaiselectronics.catalogo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.Methods;

@Component
public abstract class AbstractDao {
	
	@Autowired
	protected Methods restClient;


}
