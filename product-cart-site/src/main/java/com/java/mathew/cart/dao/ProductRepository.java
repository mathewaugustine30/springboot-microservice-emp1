package com.java.mathew.cart.dao;

import org.springframework.data.repository.CrudRepository;

import com.java.mathew.cart.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
