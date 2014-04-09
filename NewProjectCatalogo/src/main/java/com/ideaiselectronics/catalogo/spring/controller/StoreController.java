package com.ideaiselectronics.catalogo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ProductDaoBehavior;

@Controller("storeController")
@RequestMapping("/")
public class StoreController extends BaseController {
	
	@Autowired @Qualifier("productDao")
	private ProductDaoBehavior productDao;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView initializeShowcase(){
		ModelAndView view = getBaseView("catalogo/store");
		view.addObject("products", productDao.listOrderByRank());
		
		/*retornar do servico do estoque os produtos mais vendidos por categoria, além dos produtos
		 * em destaque!*/
		
		return view;
    }	

}
