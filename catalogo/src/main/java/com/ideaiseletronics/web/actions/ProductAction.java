package com.ideaiseletronics.web.actions;

import com.ideaiseletronics.web.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private static int id;
	private Product product = new Product();
	
	public String showProductDetails(){
		for (Product productSearch : listProducts) {
			if (id == productSearch.getId()) {
				this.product = productSearch;
				break;
			}
		}

		return SUCCESS;
	}

}
