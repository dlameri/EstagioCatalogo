package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiseletronics.catalogo.spring.dao.interfaces.GenericDao;
import com.ideaiseletronics.catalogo.spring.domain.Item;

@Service
public class ItemDao extends AbstractDao implements GenericDao<Item>{
	
	@Autowired
	private String stockUrlItem;  

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list() {
		return (List<Item>) restClient.get(urlAccess, new GenericType< List<Item> >() {});
	}

	@Override
	public Item findById(Long id) {
		return (Item) restClient.get(urlAccess + id, new GenericType<Item>() {});
	}

	@Override
	protected void setUrlAccess() {
		super.urlAccess = stockUrlItem;
	}

}
