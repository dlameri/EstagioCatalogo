package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.DimensionsJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

public interface ProductDaoBehavior {
	
	public List<ProductJSON> list();
	
	public ProductJSON findById(Long id);
	
	public List<ProductJSON> listOrderBySalesRank(Integer quantity);
	
	public List<ItemJSON> listItems(Long productId);
	
	public List<ProductJSON> search(String textToSearch);

	public DimensionsJSON getDimensions(Long productId);

}
