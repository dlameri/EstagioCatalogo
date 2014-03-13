package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import com.ideaiseletronics.catalogo.spring.dao.interfaces.GenericDao;
import com.ideaiseletronics.catalogo.spring.domain.Product;

public class ProductDao extends AbstractDao implements GenericDao<Product>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		return (List<Product>) restClient.get(urlAccess, new GenericType< List<Product> >(){});
	}

	@Override
	public Product findById(Long id) {
		return (Product) restClient.get(urlAccess + id, new GenericType<Product>() {});
	}

	@Override
	protected void setUrlAccess() {
		// TODO Auto-generated method stub
		
	}

}
