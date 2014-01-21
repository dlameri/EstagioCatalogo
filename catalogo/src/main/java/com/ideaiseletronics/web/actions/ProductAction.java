package com.ideaiseletronics.web.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String showProductDetails(){
		for (Product productSearch : listProducts) {
			if (id == productSearch.getIdProduct()) {
				product = productSearch;
				break;
			}
		}

		return SUCCESS;
	}

}
