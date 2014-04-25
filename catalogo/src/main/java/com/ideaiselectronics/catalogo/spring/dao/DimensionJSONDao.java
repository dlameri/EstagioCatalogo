package com.ideaiselectronics.catalogo.spring.dao;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.DimensionDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.DimensionsJSON;

@Service
public class DimensionJSONDao extends AbstractDao implements DimensionDaoBehavior{
	@Autowired
	protected String stockUrlProduct;

	@Override
	public DimensionsJSON list(Long productId) {
		return (DimensionsJSON) restClient.get(stockUrlProduct + productId + "dimensions", new GenericType< DimensionsJSON >() {});
	}
	
	
	

}
