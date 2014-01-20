package com.ideaiseletronics.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.domain.Image;
import com.ideaiseletronics.web.domain.Product;

public class ImageDao implements Dao<Image>{
	
	private List<Image> images;
	
	public ImageDao() {
		ProductDao productDao = new ProductDao();
		
		Image image1 = new Image( 1L, "http://isuba.s8.com.br/produtos/01/00/item/116607/9/116607939G1.jpg", "", "", "", "", "", true, productDao.findById( 1L ) );
		Image image2 = new Image( 2L, "http://isuba.s8.com.br/produtos/01/00/item/116607/9/116607939G1.jpg", "", "", "", "", "", false, productDao.findById( 2L ) );
		Image image3 = new Image( 3L, "http://isuba.s8.com.br/produtos/01/00/sku/7538/3/7538342G1.jpg", "", "", "", "", "", true, productDao.findById( 3L ) );
		
		save( image1 );
		save( image2 );
		save( image3 );
	}

	@Override
	public void save(Image image) {
		if( this.images == null ){
			this.images = new ArrayList<Image>();
		}
		
		this.images.add( image );
	}

	@Override
	public Image findById( Long id ) {
		for ( Image image : this.images ) {
			if( image.getId() == id ) {
				return image;
			}
		}
		
		return null;
	}

	@Override
	public List<Image> findAll() {
		return this.images;
	}
	
	public List<Image> findImagesByProduct( Product product ) {
		List<Image> list = new ArrayList<Image>();
		
		for ( Image image : this.images ) {
			if( image.getProduct().getId() == product.getId() ) {
				list.add( image );
			}
		}
		
		return list;
	}

}
