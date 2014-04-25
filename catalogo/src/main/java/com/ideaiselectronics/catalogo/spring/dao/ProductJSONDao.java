package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.DimensionsJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;



//import org.jboss.resteasy.util.GenericType; retorna um linkedHashMap ao inves de um List, nao sei pq
import javax.ws.rs.core.GenericType;

@SuppressWarnings("unchecked") 
@Service
public class ProductJSONDao extends AbstractDao implements ProductDaoBehavior {
	
	@Autowired
	protected String stockUrlProduct;
	
	@Override
	public ProductJSON findById(Long id) {
		return (ProductJSON) restClient.get(stockUrlProduct + id, new GenericType<ProductJSON>(){});
	}

	@Override
	public List<ProductJSON> list() {
		return (List<ProductJSON>) restClient.get(stockUrlProduct, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ProductJSON> listOrderByRank(int quantity) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "?maxResults=" + quantity, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ProductJSON> findByCategoryId(Long idCategory) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "bycategoryid/" + idCategory, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ProductJSON> findBySubcategoryId(Long idSubcategory) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "bysubcategoryid/"+ idSubcategory, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ProductJSON> findByName(String name) {
		return (List<ProductJSON>) restClient.get(stockUrlProduct + "search/"+ name, new GenericType< List<ProductJSON> >(){});
	}

	@Override
	public List<ItemJSON> listItems(Long productId) {
		return (List<ItemJSON>) restClient.get(stockUrlProduct + productId + "/item", new GenericType< List<ItemJSON> >(){});
	}

	@Override
	public List<ProductJSON> listTopSellersProducts(int quantity) {
		return this.listOrderByRank(quantity);
	}	
	
	@Override
	public List<DimensionsJSON> setDimensions(Long productId) {
		
		return (List<DimensionsJSON>) restClient.get(stockUrlProduct + productId + "dimensions", new GenericType< List<DimensionsJSON> >() {});
	}

}
