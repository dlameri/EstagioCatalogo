package com.ideaiseletronics.web.actions;

import java.util.List;

import com.ideaiseletronics.web.dao.CategoryDao;
import com.ideaiseletronics.web.dao.ProductDao;
import com.ideaiseletronics.web.domain.Category;
import com.ideaiseletronics.web.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ShowcaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private final CategoryDao categoryDao = new CategoryDao();
	private final ProductDao productDao = new ProductDao();
	
	private List<Category> listCategories;
	private List<Product> listProducts;
	private String idCategory;
	
	private String message;
	
	public String execute() {
		initializingShowcase();
		
		return SUCCESS;
	}
	
	public String showProductsByCategory() {
		initializingCategories();
		
		this.listProducts = productDao.findProductsByCategory( Long.valueOf( this.idCategory ) );
		
		return SUCCESS;
	}
	
	public void initializingShowcase() {
		initializingCategories();
		initializingProducts();
	}
	
	public void initializingCategories() {
		this.listCategories = this.categoryDao.findAll();
	}
	
	public void initializingProducts() {
		this.listProducts = this.productDao.findAll();
	}
	
	public List<Category> getListCategories() {
		return listCategories;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getMessage() {
		return message;
	}

}
