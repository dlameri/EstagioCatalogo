package com.ideaiselectronics.catalogo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.SubcategoryDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.SubcategoryJSON;
import com.ideaiselectronics.catalogo.spring.service.interfaces.SubcategoryServiceBehavior;

@Service
public class SubcategoryService implements SubcategoryServiceBehavior {
	
	@Autowired @Qualifier("subcategoryJSONDao")
	private SubcategoryDaoBehavior subcategoryDao;

	@Override
	public SubcategoryJSON getSubcategory( Long subcategoryId ) {
		return subcategoryDao.findById( subcategoryId );
	}

}
