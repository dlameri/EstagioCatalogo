package com.ideaiseletronics.web.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideaiseletronics.web.domain.Item;
import com.ideaiseletronics.web.domain.Product;

public class ItemDao extends AbstractDao<Item>{
	
	public ItemDao() {
		super( Item.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> findItemsByCategory( Long idCategory ) {
		Transaction transaction = null;
		List<Item> items = null;
		try {
			transaction = session().beginTransaction();
			items = session().createCriteria(Product.class)
					.add( Restrictions.eq( "product.category.id", idCategory ) ).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
		
		return items;
	}
		
}
