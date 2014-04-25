package com.ideaiselectronics.catalogo.spring.dao.interfaces;


import com.ideaiselectronics.catalogo.spring.domain.json.DimensionsJSON;

public interface DimensionDaoBehavior {

	public DimensionsJSON list(Long productId);

	
}
