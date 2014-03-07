package com.ideaiseletronics.catalogo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.spring.dao.ProductDao;
import com.ideaiseletronics.stock.domain.Product;

@Service
public class ProductService implements GenericService<Product>{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Long create(Product product) {
		return productDao.save(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> list() {
		return productDao.findAll(Product.class);
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(Product.class, id);
	}
	
	public List<Product> findProductsByCategory(Long idCategory){
		return productDao.findProductsByCategory(idCategory);
	}
	
	/* GETTERS AND SETTERS */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
