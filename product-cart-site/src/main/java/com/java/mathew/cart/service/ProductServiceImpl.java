package com.java.mathew.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mathew.cart.dao.FileUploadRepository;
import com.java.mathew.cart.dao.ProductRepository;
import com.java.mathew.cart.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public Product addProduct(Product country) {
		return productRepository.save(country);
	}

	@Override
	public Product getProduct(Integer countryId) {
		Optional<Product> findById = productRepository.findById(countryId);
		return findById.get();
	}

	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product country) {
		// TODO Auto-generated method stub
		return productRepository.save(country);
	}

	@Override
	public void deleteProduct(Integer countryId) {
		productRepository.deleteById(countryId);
	}

}
