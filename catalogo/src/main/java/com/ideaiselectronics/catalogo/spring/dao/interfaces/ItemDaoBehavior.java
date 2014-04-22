package com.ideaiselectronics.catalogo.spring.dao.interfaces;

import java.util.List;

import com.ideaiselectronics.catalogo.spring.domain.json.ImageJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;

public interface ItemDaoBehavior {
	
	public ItemJSON findById(Long id);
	
	public List<ItemJSON> list();
	
	public List<ImageJSON> listImages(Long itemId);

}
