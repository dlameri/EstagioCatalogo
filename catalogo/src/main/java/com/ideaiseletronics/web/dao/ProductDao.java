package com.ideaiseletronics.web.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideaiseletronics.web.domain.Product;

public class ProductDao extends AbstractDao<Product>{	
	
	public ProductDao() {
		super( Product.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findItemsByCategory( Long idCategory ) {
		Transaction transaction = null;
		List<Product> products = null;
		try {
			transaction = session().beginTransaction();
			products = session().createCriteria(Product.class)
					.add( Restrictions.eq( "category.id", idCategory ) ).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
		
		return products;
	}

}
