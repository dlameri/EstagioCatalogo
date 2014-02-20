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
	
	private List<Category> categories;
	private List<Product> products;
	private String idCategory;
	
	private String message;
	
	public String execute() {
		initializingShowcase();
		
		return SUCCESS;
	}
	
	public String showProductsByCategory() {
		initializingCategories();
		
		this.products = productDao.findItemsByCategory( Long.valueOf( this.idCategory ) );
		
		return SUCCESS;
	}
	
	public void initializingShowcase() {
		initializingCategories();
		initializingProducts();
	}
	
	public void initializingCategories() {
		this.categories = this.categoryDao.findAll();
	}
	
	public void initializingProducts() {
		this.products = this.productDao.findAll();
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getMessage() {
		return message;
	}

}
