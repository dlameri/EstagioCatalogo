package com.ideaiselectronics.catalogo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

@Controller("storeController")
@RequestMapping("/")
public class StoreController extends BaseController {
	
	@Autowired @Qualifier("productJSONDao")
	private ProductDaoBehavior productJSONDao;
	@Autowired @Qualifier("itemJSONDao")
	private ItemDaoBehavior itemJSONDao;
	private static final int TOP_SELLERS_QUANTITY = 10;
	private static final Long TOP_SELLERS_CATEGORY_ID_FIRST_SECTION = 1L;
	private static final Long TOP_SELLERS_CATEGORY_ID_SECOND_SECTION = 2L;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		ModelAndView view = getBaseView("catalogo/store");
		view.addObject("topSellersProducts", listTopSellersProducts(TOP_SELLERS_QUANTITY));
		view.addObject("topSellersProductsFirstSection", listTopSellersProductsByCategory(TOP_SELLERS_CATEGORY_ID_FIRST_SECTION));
		view.addObject("topSellersProductsSecondSection", listTopSellersProductsByCategory(TOP_SELLERS_CATEGORY_ID_SECOND_SECTION));
		
		/*retornar do servico produtos em destaque!*/
		
		return view;
    }
	
	private List<ProductJSON> listTopSellersProductsByCategory(Long categoryId) {
		List<ProductJSON> topSellersProductsByCategory = categoryJSONDao.listTopSellersProducts(categoryId);
		for (ProductJSON productJSON : topSellersProductsByCategory) {
			setItems(productJSON);
			setImages(productJSON);
		}
		return topSellersProductsByCategory; 
	}
	
	private List<ProductJSON> listTopSellersProducts(int quantity) {
		List<ProductJSON> topSellersProducts = productJSONDao.listTopSellersProducts(quantity);
		for (ProductJSON productJSON : topSellersProducts) {
			setItems(productJSON);
			setImages(productJSON);
		}
		return topSellersProducts;
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