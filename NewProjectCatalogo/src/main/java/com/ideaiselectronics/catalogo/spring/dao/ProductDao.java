package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.Product;

@Service
public class ProductDao extends AbstractDao implements ProductDaoBehavior{
	
	@Autowired
	protected String stockUrlProduct;
	
	@Override
	public Product findById(Long id) {
		return (Product) restClient.get(stockUrlProduct + id, new GenericType<Product>() {});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		return (List<Product>) restClient.get(stockUrlProduct, new GenericType< List<Product> >(){});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listOrderByRank() {
		return (List<Product>) restClient.get(stockUrlProduct + "orderbyrank", new GenericType< List<Product> >(){});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByCategoryId(Long idCategory) {
		return (List<Product>) restClient.get(stockUrlProduct + "bycategoryid/" + idCategory, new GenericType< List<Product> >(){});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findBySubcategoryId(Long idSubcategory) {
		return (List<Product>) restClient.get(stockUrlProduct + "bysubcategoryid/"+ idSubcategory, new GenericType<List <Product> >(){});
	}

}
