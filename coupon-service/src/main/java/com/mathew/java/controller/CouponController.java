package com.mathew.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathew.java.CouponServiceApplication;
import com.mathew.java.entity.Coupon;
import com.mathew.java.repositiory.CouponsRepository;

@RestController
@RequestMapping("/couponsapi")
public class CouponController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	private CouponsRepository couponsRepository;
	
	
	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponsRepository.save(coupon);
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		logger.info("getCoupon Called-----"); 
		logger.info("{}", code);  
		return couponsRepository.getByCode(code);
		
	}

}
