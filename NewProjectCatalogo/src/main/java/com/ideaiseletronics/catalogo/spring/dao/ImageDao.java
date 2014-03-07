package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ideaiseletronics.stock.domain.Image;
import com.ideaiseletronics.stock.domain.Product;

public class ImageDao extends AbstractDao<Image> {
	
	public ImageDao() {
		super();
	}
			
	@SuppressWarnings("unchecked")
	public List<Image> findImagesByProduct( Product product ) {
		Transaction transaction = null;
		List<Image> images = null;
		try {
			transaction = session().beginTransaction();
			images = session().createCriteria(Image.class)
					.add( Restrictions.eq( "product.id", product.getId() ) ).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
		
		return images;
	}

}
