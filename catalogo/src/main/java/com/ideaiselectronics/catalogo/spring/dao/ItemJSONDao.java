package com.ideaiselectronics.catalogo.spring.dao;

import java.util.List;

//import org.jboss.resteasy.util.GenericType; retorna um linkedHashMap ao inves de um List, nao sei pq
import javax.ws.rs.core.GenericType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.dao.interfaces.ItemDaoBehavior;
import com.ideaiselectronics.catalogo.spring.domain.json.ImageJSON;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;

@Service
public class ItemJSONDao extends AbstractDao implements ItemDaoBehavior {
	
	@Autowired
	private String stockUrlItem;

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemJSON> list() {
		return (List<ItemJSON>) restClient.get(stockUrlItem, new GenericType< List<ItemJSON> >(){});
	}

	
	@Override
	public ItemJSON findById(Long id) {
		return (ItemJSON) restClient.get(stockUrlItem + id, new GenericType< ItemJSON >(){});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ImageJSON> listImages(Long itemId) {
		return (List<ImageJSON>) restClient.get(stockUrlItem + itemId + "/image", new GenericType< List<ImageJSON> >(){});
	}

}
