package com.java.mathew.cart.service;

import java.util.List;

import com.java.mathew.cart.entity.Product;


public interface ProductService {
	
	Product addProduct(Product product);
	
	Product getProduct(Integer productId);
	
	Iterable<Product> getAllProducts();
	
	Product updateProduct(Product product);
	
	void deleteProduct(Integer ProductId);

}
