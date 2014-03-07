package com.ideaiseletronics.catalogo.api.resteasy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ideaiseletronics.catalogo.spring.service.CategoryService;
import com.ideaiseletronics.catalogo.spring.service.GenericService;
import com.ideaiseletronics.stock.domain.Category;
import com.ideaiseletronics.stock.domain.Subcategory;

@Component
@Path("/category")
public class RestEasyCategory {
	
	@Autowired
	private GenericService<Category> categoryService;
	
	@GET
	@Path("/list")
	@Produces( { MediaType.APPLICATION_JSON })
	public Category getCategories(){
		Category cat = new Category();
		cat.setName("teste");
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		Subcategory sub1 = new Subcategory();
		sub1.setName("Sub1");
		Subcategory sub2 = new Subcategory();
		sub2.setName("Sub2");
		subcategories.add(sub1);
		subcategories.add(sub2);
		cat.setSubcategories(subcategories);
		return cat;
	}
	
	@POST
	@PUT
	@Path("/sendCategory")
	@Consumes( { MediaType.APPLICATION_JSON })
	public Response setCategory(Category cat){
		String out = cat.toString();
		return Response.status(200).entity(out).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces( { MediaType.APPLICATION_JSON })
	public Category getCategory(@PathParam("id") Long id){
		Category category = new Category();
		category.setId(id);
		category.setName("categoria passando id");
		return category;
	}
	
	/* GETTERS AND SETTERS */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
