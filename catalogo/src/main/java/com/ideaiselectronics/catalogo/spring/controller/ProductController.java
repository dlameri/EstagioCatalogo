package com.ideaiselectronics.catalogo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

@Controller("productController")
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	@Autowired @Qualifier("productJSONDao")
	private ProductDaoBehavior productJSONDao;
	@Autowired @Qualifier("itemJSONDao")
	private ItemDaoBehavior itemJSONDao;
	
	@RequestMapping( value="/{productId}", method = RequestMethod.GET )
	public ModelAndView showProductDetails( @PathVariable("productId") Long productId ) {
		ModelAndView view = getBaseView("catalogo/productDetails");
		view.addObject("product", productJSONDao.findById(productId));
		return view;
	}
	
	@RequestMapping ( value = "/search", method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam(value="name", required=false) String productName ) {
		ModelAndView view = getBaseView("catalogo/productSearch");
		view.addObject("products", getProducts(productName));
		System.out.println(view);
		return view;
	}
	
	public List<ProductJSON> getProducts(String name) {
		List<ProductJSON> products = productJSONDao.findByName(name);
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
