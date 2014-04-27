package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;



//import org.jboss.resteasy.util.GenericType; retorna um linkedHashMap ao inves de um List, nao sei pq
import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;


@Service
public class SubcategoryJSONDao extends AbstractDao implements SubcategoryDaoBehavior {
	
	@Autowired
	protected String stockUrlSubcategory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubcategoryJSON> list() {
		return (List<SubcategoryJSON>) restClient.get(stockUrlSubcategory, new GenericType<SubcategoryJSON>(){});
	}
	
	@Override
	public SubcategoryJSON findById(Long id) {
		return (SubcategoryJSON) restClient.get(stockUrlSubcategory + id,  new GenericType<SubcategoryJSON>(){});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductJSON> listProductsBySubcategory(Long subcategoryId) {
		return (List<ProductJSON>) restClient.get(stockUrlSubcategory + subcategoryId + "/product", new GenericType<ProductJSON>(){});
	}

}
