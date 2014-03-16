package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.GenericDao;
import com.ideaiselectronics.catalogo.spring.domain.Product;

@Service
public class ProductDao extends AbstractDao implements GenericDao<Product>{
	
	@Autowired
	protected String stockUrlProduct;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		return (List<Product>) restClient.get(stockUrlProduct, new GenericType< List<Product> >(){});
	}

	@Override
	public Product findById(Long id) {
		return (Product) restClient.get(stockUrlProduct + id, new GenericType<Product>() {});
	}

}
