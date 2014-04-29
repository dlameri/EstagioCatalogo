package com.ideaiselectronics.catalogo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.CategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.ProductServiceBehavior;

@Service
public class ProductService implements ProductServiceBehavior {
	
	@Autowired @Qualifier("productJSONDao")
	private ProductDaoBehavior productDao;
	@Autowired @Qualifier("itemJSONDao")
	private ItemDaoBehavior itemDao;
	@Autowired @Qualifier("categoryJSONDao")
	protected CategoryDaoBehavior categoryDao;
	
	@Autowired @Qualifier("subcategoryJSONDao")
	protected SubcategoryDaoBehavior subcategoryDao;

	@Override
	public List<ProductJSON> listTopSellersProducts( Integer quantity ) {
		List<ProductJSON> topSellersProducts = productDao.listOrderBySalesRank( quantity );
		for (ProductJSON productJSON : topSellersProducts) {
			fillProductJSON(productJSON);
		}
		return topSellersProducts;
	}

	@Override
	public List<ProductJSON> listTopSellersProductsByCategory( Long categoryId ) {
		List<ProductJSON> topSellersProductsByCategory = categoryDao.listTopSellersProducts( categoryId );
		for (ProductJSON productJSON : topSellersProductsByCategory) {
			fillProductJSON(productJSON);
		}
		return topSellersProductsByCategory;
	}
	
	@Override
	public List<ProductJSON> listProductsByCategory( Long categoryId ) {
		List<ProductJSON> products = categoryDao.listProductsByCategory( categoryId );
		for (ProductJSON productJSON : products) {
			fillProductJSON(productJSON);
		}
		return products;
	}
	
	@Override
	public List<ProductJSON> listProductsBySubcategory( Long subcategoryId ) {
		return subcategoryDao.listProductsBySubcategory( subcategoryId );
	}

	@Override
	public ProductJSON getProductWithAllPropertiesFilled( Long productId ) {
		ProductJSON product = productDao.findById( productId );
		setItems(product);
		setImages( product );
		setDimensions( product );
		return product;
	}

	@Override
	public List<ProductJSON> search( String textToSearch ) {
		return productDao.search( textToSearch );
	}

	@Override
	public List<ProductJSON> listPaginatedProducts( Long categoryId, Integer firstResult, Integer maxResults ) {
		List<ProductJSON> products = categoryDao.listPaginatedProducts( categoryId, firstResult, maxResults );
		fillProducts(products);
		return products;
	}
	
	private void setItems( ProductJSON productJSON ) {
		productJSON.setItems( productDao.listItems( productJSON.getId() ) );
	}
	
	private void setImages( ProductJSON productJSON ) {
		if(productJSON.getItems() != null){
			for (ItemJSON itemJSON : productJSON.getItems()) {
				itemJSON.setImages( itemDao.listImages( itemJSON.getId() ) );
			}
		}
	}
	
	private void setDimensions( ProductJSON productJSON ) {
		productJSON.setDimensions( productDao.getDimensions( productJSON.getId() ) );
	}
	
	private void fillProductJSON(ProductJSON productJSON) {
		setItems( productJSON );
		setImages( productJSON );
	}
	
	private void fillProducts( List<ProductJSON> products ) {
		if( products != null ){
			for (ProductJSON productJSON : products) {
				setItems( productJSON );
				setImages( productJSON );
				setDimensions( productJSON );
			}
		}
	}

}
