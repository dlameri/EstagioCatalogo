package com.ideaiseletronics.web.actions;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private static int id;
	private Product product = new Product();
	private List<Product> Products;
	
	private static List getList(){
		List< Product > products = new ArrayList<Product>();
			products.add( new Product( ) );
			products.add( new Product( ) );
			products.add( new Product( ) );
			return products;
	}
	
	public String showProductDetails(){
		Products = getList();
		for (Product productSearch : Products) {
			if (id == productSearch.getId()) {
				this.product = productSearch;
				break;
			}
		}

		return SUCCESS;
	}

}
