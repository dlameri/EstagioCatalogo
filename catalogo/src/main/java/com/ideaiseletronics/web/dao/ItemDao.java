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
		
}
