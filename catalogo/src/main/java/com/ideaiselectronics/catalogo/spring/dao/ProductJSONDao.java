package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

//import org.jboss.resteasy.util.GenericType; retorna um linkedHashMap ao inves de um List, nao sei pq
import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.DimensionsJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

@SuppressWarnings("unchecked") 
@Service
public class ProductJSONDao extends AbstractDao implements ProductDaoBehavior {
	
	@Autowired
	protected String stockUrlProduct;
	
	@Override
	public List<ProductJSON> list() {
		return (List<ProductJSON>) restClient.get(stockUrlProduct, new GenericType< List<ProductJSON> >(){});
	}
	
	@Override
	public ProductJSON findById(Long id) {
		return (ProductJSON) restClient.get(stockUrlProduct + id, new GenericType<ProductJSON>(){});
	}

	@Override
	public List<ProductJSON> listOrderBySalesRank(Integer quantity) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "?maxResults=" + quantity, new GenericType< List<ProductJSON> >(){});
	}
	
	@Override
	public List<ProductJSON> search(String textToSearch) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "search/"+ textToSearch, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ItemJSON> listItems(Long productId) {
		return (List<ItemJSON>) restClient.get(stockUrlProduct + productId + "/item", new GenericType< List<ItemJSON> >(){});
	}

	@Override
	public DimensionsJSON getDimensions(Long productId) {
		return (DimensionsJSON) restClient.get(stockUrlProduct + productId + "/dimensions", new GenericType< DimensionsJSON >(){});
	}
	
	@Override
	public List<ProductJSON> getPromoProducts(Boolean promo) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "?promo="+promo, new GenericType< List<ProductJSON> >(){});
	}

}
