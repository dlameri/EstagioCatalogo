package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.stock.domain.Product;

@Service
public class ProductDao extends AbstractDao<Product>{	
	
	public ProductDao() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByCategory( Long idCategory ) {	
		return session().createCriteria(Product.class).add( Restrictions.eq( "category.id", idCategory ) ).list();
	}

}
