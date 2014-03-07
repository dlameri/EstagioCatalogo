package com.ideaiseletronics.catalogo.api.jackson;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideaiseletronics.catalogo.spring.service.CategoryService;
import com.ideaiseletronics.catalogo.spring.service.GenericService;
import com.ideaiseletronics.stock.domain.Category;

@Component
@RequestMapping("/api/rest")
public class JacksonCategory {
	
	@Autowired
	private GenericService<Category> categoryService;
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	@Produces({MediaType.APPLICATION_JSON})
	public @ResponseBody Category getCategory() {
		
		return categoryService.findById(2L);
	}
	
	/* GETTERS AND SETTERS */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
