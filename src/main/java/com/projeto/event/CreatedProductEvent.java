package com.projeto.event;

import javax.servlet.http.HttpServletResponse;

import com.projeto.model.Product;

public class CreatedProductEvent extends CreatedResourceEvent<Long, Product> {

	private Product createdProduct;

	public CreatedProductEvent(Product event, HttpServletResponse response) {
		super(event.getId(), event, response);
		this.createdProduct = event;
	}

	public Product getcreatedProduct() {
		return createdProduct;
	}

}
