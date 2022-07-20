package com.projeto.event;

import javax.servlet.http.HttpServletResponse;

public class CreatedResourceEvent<K, T> {
	private K id;
	private T resource;
	private HttpServletResponse response;

	public CreatedResourceEvent(T resource) {
		this.resource = resource;
	}

	public CreatedResourceEvent(K id, T resource, HttpServletResponse response) {
		this.id = id;
		this.resource = resource;
		this.response = response;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public T getResource() {
		return resource;
	}

	public void setResource(T resource) {
		this.resource = resource;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
