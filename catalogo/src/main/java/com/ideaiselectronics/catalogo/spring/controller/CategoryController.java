package com.ideaiselectronics.catalogo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.CategoryJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;

@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@Autowired @Qualifier("productJSONDao")
	private ProductDaoBehavior productJSONDao;
	@Autowired @Qualifier("itemJSONDao")
	private ItemDaoBehavior itemJSONDao;
	
	@RequestMapping( value="/{categoryId}/product", method = RequestMethod.GET )
	public ModelAndView productsByCategory( @PathVariable("categoryId") Long categoryId) {
		ModelAndView view = getBaseView("catalogo/productsByCategory");
		view.addObject("category", getCategory(categoryId));
//		view.addObject("products", productJSONDao.findByCategoryId(categoryId)); voltar com isso depois q a classe ProductJSON estiver feita
		view.addObject("products", findProducts(categoryId));
		
		return view;
	}
	
	private CategoryJSON getCategory(Long categoryId) {
		CategoryJSON category = categoryJSONDao.findById(categoryId);
		category.setSubcategories(setSubcategories(categoryId));
		return category;
	}
	
	private List<SubcategoryJSON> setSubcategories(Long categoryId) {
		return categoryJSONDao.listSubcategories(categoryId);
	}
	
	private List<ProductJSON> findProducts(Long categoryId) {
		//List<ProductJSON> products = productJSONDao.findByCategoryId(categoryId);
		//tratar caso retorne produtos nulos
		List<ProductJSON> products = categoryJSONDao.listTopSellersProducts(categoryId);
		for (ProductJSON productJSON : products) {
			setItems(productJSON);
			setImages(productJSON);
		}
		return products; 
	}
	
	private void setImages(ProductJSON productJSON) {
		for (ItemJSON itemJSON : productJSON.getItems()) {
			itemJSON.setImages( itemJSONDao.listImages(itemJSON.getId()) );
		}
	}
	
	private void setItems(ProductJSON productJSON) {
		productJSON.setItems( productJSONDao.listItems(productJSON.getId()) );
	}

}
