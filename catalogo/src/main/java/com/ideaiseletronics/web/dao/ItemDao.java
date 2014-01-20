package com.ideaiseletronics.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.domain.Dimensions;
import com.ideaiseletronics.web.domain.Item;

public class ItemDao implements Dao<Item> {
	
	private List<Item> items;
	
	public ItemDao() {
		CategoryDao categoryDao = new CategoryDao();
		
		Item item = new Item( 1L, "O Hobbit J.R.R Tolkien", "Livro que tem filme blablablablablablablablablablablablablablabla", "Livro sobre o hobbit", 20, 6, "Wmf Martins Fontes", "Livro", null, categoryDao.findById( 1L ), new Dimensions( 1L, 256D, 256D, 12D ) );
		Item item2 = new Item( 2L, "Um livro qualquer", "Livro qualquer blablablablablablablablablablablablablablabla", "Livro sobre qualquer coisa", 20, 6, "Wmf Martins Fontes", "Livro", null, categoryDao.findById( 1L ), new Dimensions( 1L, 256D, 256D, 12D ) );
		Item item3 = new Item( 3L, "Livro - A Tormenta de Espadas - As Crônicas de Gelo e Fogo - Livro 3", "Livro que fala sobre blablablablablablablablablablablablablablabla", "Livro sobre a tormenta das espadas", 20, 6, "Wmf Martins Fontes", "Livro", null, categoryDao.findById( 2L ), new Dimensions( 1L, 256D, 256D, 12D ) );
		
		save( item );
		save( item2 );
		save( item3 );
	}

	@Override
	public void save( Item item ) {
		if( this.items == null ){
			this.items = new ArrayList<Item>();
		}
		
		this.items.add( item );
	}

	@Override
	public Item findById( Long id ) {
		for ( Item item : this.items ) {
			if( item.getId() == id ){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<Item> findAll() {
		return this.items;
	}

}
