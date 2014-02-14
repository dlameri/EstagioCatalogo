package com.ideaiseletronics.web.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideaiseletronics.web.domain.Product;

public class ProductDao extends AbstractDao<Product>{	
	
	public ProductDao() {
		super( Product.class );
	}

}
