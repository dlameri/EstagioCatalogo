package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.Category;
import com.ideaiselectronics.catalogo.spring.domain.Subcategory;


@Service
public class SubcategoryDao extends AbstractDao implements SubcategoryDaoBehavior {
	
	@Autowired
	protected String stockUrlSubcategory;
	
	@Override
	public Subcategory findById(Long id) {
		return (Subcategory) restClient.get(stockUrlSubcategory + id, new GenericType<Subcategory>() {});
	}
	
	
	@Override
	public List<Subcategory> list() {
		return (List<Subcategory>) restClient.get(stockUrlSubcategory, new GenericType< List<Subcategory> >() {});
	}
	
	
}
