package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.Item;

public interface ItemDaoBehavior {
	
	public Item findById(Long id);
	
	public List<Item> list();

}
