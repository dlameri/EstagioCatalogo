package com.ideaiseletronics.catalogo.api.service;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.springframework.stereotype.Component;

import com.ideaiseletronics.catalogo.api.service.interfaces.ClientMethods;

@Component
public class RESTClient implements ClientMethods{

	private final static int STATUS_OK = 200;
	private ResteasyClient client = new ResteasyClientBuilder().build();

	public RESTClient() {
	}

	@Override
	public <T> Object get(String url, GenericType<T> type) {
		Response response = client.target(url).request().get();
		if (response.getStatus() == STATUS_OK) {
			return response.readEntity(type);
			//return JsonUtil.readJsonToObject(json, type);
		}

		return null;
	}

	@Override
	public void post(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void put(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void options() {
		// TODO Auto-generated method stub
		
	}

}
