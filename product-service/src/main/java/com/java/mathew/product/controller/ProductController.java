package com.java.mathew.product.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mathew.product.entity.Coupon;
import com.java.mathew.product.entity.Product;
import com.java.mathew.product.repository.ProductRepository;

import io.github.resilience4j.retry.annotation.Retry;

import com.java.mathew.product.clent.CouponService;

@RestController
@RequestMapping("/productsapi")
public class ProductController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/products")
	@Retry(name="product-api", fallbackMethod = "handleError")
	public Product createProduct(@RequestBody Product product) {
		logger.info("createProduct method called----------");  
		Coupon coupon =couponService.getCoupon(product.getCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		logger.info("{}", product.getId());
		return productRepository.save(product);
	}
	
	public Product handleError(Product product,Exception exception) {
		return product;
	}
	

}
