package com.javaguides.springboot.service;

import java.util.List;

import com.javaguides.springboot.model.product;

public interface ProductService {

	product createProduct(product product);
	
	product updateProduct(product product);
	
	List<product> getAllProduct();
	
	product getProductById(long productId);
	
	void deletProduct(long id);
	
}
