package com.java.mathew.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.mathew.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
