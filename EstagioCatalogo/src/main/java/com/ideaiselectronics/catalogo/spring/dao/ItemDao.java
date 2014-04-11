package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.Item;

@Service
public class ItemDao extends AbstractDao implements ItemDaoBehavior {
	
	@Autowired
	private String stockUrlItem;  

	@Override
	public Item findById(Long id) {
		return (Item) restClient.get(stockUrlItem + id, new GenericType<Item>() {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list() {
		return (List<Item>) restClient.get(stockUrlItem, new GenericType< List<Item> >() {});
	}

}
