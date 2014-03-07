package com.ideaiseletronics.catalogo.api.rest.util;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.type.TypeReference;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.springframework.stereotype.Component;

import com.ideaiseletronics.catalogo.api.rest.service.ClientMethods;

@Component
public class RESTClient implements ClientMethods{

	private final static int STATUS_OK = 200;
	private ResteasyClient client = new ResteasyClientBuilder().build();

	public RESTClient() {
	}

	@Override
	public <T> Object get(String url, TypeReference<T> type) {
		Response response = client.target(url).request().get();
		if (response.getStatus() == STATUS_OK) {
			String json = "[{" 
					+"\"id\": 1," 
					+"\"name\": \"categoria 1\","
					+ "\"subcategories\": []},"
					+ "{" 
					+"\"id\": 2," 
					+"\"name\": \"categoria 2\","
					+ "\"subcategories\": []}"
					+ "]";

			return JsonUtil.readJsonToObject(json, type);
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
