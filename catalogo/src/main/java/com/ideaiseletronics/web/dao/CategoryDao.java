package com.ideaiseletronics.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.domain.Category;

public class CategoryDao implements Dao<Category> {
	
	private List<Category> categories;
	
	public CategoryDao() {
		save( new Category(1L, "Livro") );
		save( new Category(2L, "DVDs e Blu-ray") );
		save( new Category(3L, "Games") );
		save( new Category(4L, "Celulares e Telefones") );
		save( new Category(5L, "Tv, Áudio e Home Theater") );
		save( new Category(6L, "Eletrodomésticos") );
		save( new Category(7L, "Eletroportáteis") );
		save( new Category(8L, "Móveis e Decoração") );
		save( new Category(9L, "Moda") );
	}
	
	@Override
	public void save( Category category ) {
		if( this.categories == null ){
			this.categories = new ArrayList<Category>();
		}
		
		this.categories.add( category );
	}

	@Override
	public Category findById( Long id ) {
		for ( Category category : this.categories ) {
			if( category.getId() == id ){
				return category;
			}
		}
		
		return null;
	}

	@Override
	public List<Category> findAll() {
		return this.categories;
	}

}
