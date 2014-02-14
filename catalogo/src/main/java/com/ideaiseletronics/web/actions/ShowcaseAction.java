package com.ideaiseletronics.web.actions;

import java.util.List;

import com.ideaiseletronics.web.dao.CategoryDao;
import com.ideaiseletronics.web.dao.ItemDao;
import com.ideaiseletronics.web.domain.Category;
import com.ideaiseletronics.web.domain.Item;
import com.opensymphony.xwork2.ActionSupport;

public class ShowcaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private final CategoryDao categoryDao = new CategoryDao();
	private final ItemDao itemDao = new ItemDao();
	
	private List<Category> categories;
	private List<Item> items;
	private String idCategory;
	
	private String message;
	
	public String execute() {
		initializingShowcase();
		
		return SUCCESS;
	}
	
	public String showItemsByCategory() {
		initializingCategories();
		
		this.items = itemDao.findItemsByCategory( Long.valueOf( this.idCategory ) );
		
		return SUCCESS;
	}
	
	public void initializingShowcase() {
		initializingCategories();
		initializingItems();
	}
	
	public void initializingCategories() {
		this.categories = this.categoryDao.findAll();
	}
	
	public void initializingItems() {
		this.items = this.itemDao.findAll();
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getMessage() {
		return message;
	}

}
