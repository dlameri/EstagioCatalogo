package com.ideaiseletronics.web.actions;

import java.util.ArrayList;
import java.util.List;

import com.ideaiseletronics.web.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<Product> listProducts = new ArrayList<Product>();
	
	public String listProducts(){
		listProducts.add(new Product(Long.valueOf(1), "Notebook"));
		listProducts.add(new Product(Long.valueOf(2), "Celular"));
		listProducts.add(new Product(Long.valueOf(3), "Livro"));	
		return SUCCESS;
	}
	
	public String showProductDetails(Product product){	
		return SUCCESS;
	}
	
	public List<Product> getListProducts(){
		return this.listProducts;
	}

}
