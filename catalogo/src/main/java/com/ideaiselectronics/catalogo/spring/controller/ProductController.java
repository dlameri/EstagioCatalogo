package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.DimensionDaoBehavior;
import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ProductJSON;

@Controller("productController")
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	@Qualifier("productJSONDao")
	private ProductDaoBehavior productJSONDao;

	@Autowired
	@Qualifier("dimensionJSONDao")
	private DimensionDaoBehavior dimensionJSONDao;
	
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ModelAndView showProductDetails(
			@PathVariable("productId") Long productId) {
		ModelAndView view = getBaseView("catalogo/productDetails");

		ProductJSON product = creatingProduct(productId);

		view.addObject("product", product);
		return view;
	}

	private ProductJSON creatingProduct(Long productId) {
		ProductJSON product = new ProductJSON();
		product = productJSONDao.findById(productId);
		product.setDimensions(dimensionJSONDao.list(productId));
		return product;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchProduct(
			@RequestParam(value = "name", required = false) String productName) {
		ModelAndView view = getBaseView("catalogo/productSearch");

		view.addObject("product", productJSONDao.findByName(productName));
		return view;
	}

}
