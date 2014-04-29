package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;



//import org.jboss.resteasy.util.GenericType; retorna um linkedHashMap ao inves de um List, nao sei pq
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.CategoryJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;

@Service
public class CategoryJSONDao extends AbstractDao implements CategoryDaoBehavior {

	@Autowired
	private String stockUrlCategory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryJSON> list() {
		return (List<CategoryJSON>) restClient.get(stockUrlCategory, new GenericType< List<CategoryJSON> >(){});
	}
	
	@Override
	public CategoryJSON findById(Long id) {
		return (CategoryJSON) restClient.get(stockUrlCategory + id, new GenericType<CategoryJSON>(){});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubcategoryJSON> listSubcategories(Long categoryId) {
		return (List<SubcategoryJSON>) restClient.get(stockUrlCategory + categoryId + "/subcategory", new GenericType< List<SubcategoryJSON> >(){});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductJSON> listProductsByCategory(Long categoryId) {
		return (List<ProductJSON>) restClient.get(stockUrlCategory + categoryId + "/product", new GenericType< List<ProductJSON> >(){});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductJSON> listTopSellersProducts(Long categoryId) {
		return (List<ProductJSON>) restClient.get(stockUrlCategory + categoryId + "/topproducts", new GenericType< List<ProductJSON> >(){});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductJSON> listPaginatedProducts(Long categoryId, Integer firstResult, Integer maxResults) {
		return (List<ProductJSON>) restClient.get(stockUrlCategory + categoryId + "/product?maxResults=" + maxResults + "&firstResult=" + firstResult, new GenericType< List<ProductJSON> >(){});
	}

}
