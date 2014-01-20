package com.ideaiseletronics.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.domain.Product;

public class ProductDao implements Dao<Product> {
	
	private List<Product> products;	
	
	public ProductDao() {
		ItemDao itemDao = new ItemDao();
		
		Product product1 = new Product(1L, 5L, 39.90, 34.90, "Livro O Hobbit", "", 25, itemDao.findById( 1L ), null); 
		Product product2 = new Product(2L, 120L, 59.90, 49.90, "Livro Qualquer", "", 100, itemDao.findById( 2L ), null);
		Product product3 = new Product(3L, 100L, 68.90, 65.90, "Livro A Tormenta das espadas", "", 50, itemDao.findById( 3L ), null);
		
		save( product1 );
		save( product2 );
		save( product3 );
	}
	
	@Override
	public void save( Product product ) {
		if( this.products == null ){
			this.products = new ArrayList<Product>();
		}
		
		this.products.add( product );
	}

	@Override
	public Product findById( Long id ) {
		for ( Product product : this.products ) {
			if( product.getId() == id ){
				return product;
			}
		}
		
		return null;
	}

	@Override
	public List<Product> findAll() {
		ImageDao imageDao = new ImageDao();
		for (int i = 0; i < this.products.size(); i++) {
			Product product = this.products.get(i); 
			product.setImages( imageDao.findImagesByProduct( product ) );
			if( !product.hasImageMain() ){
				this.products.remove( product );
				i--;
			}
		}
		
		return this.products;
	}
	
	public List<Product> findProductsByCategory( Long idCategory ) {
		ImageDao imageDao = new ImageDao();
		
		List<Product> list = new ArrayList<Product>();
		for ( Product product : this.products ) {
			if( product.getItem().getCategory().getId() == idCategory ){
				product.setImages( imageDao.findImagesByProduct(product) );
				if( product.hasImageMain() ){
					list.add( product );
				}
			}
		}
		
		return list;
	}

}
