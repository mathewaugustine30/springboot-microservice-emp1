package com.java.mathew.product.clent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.mathew.product.entity.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponService {
	
	@GetMapping("/couponsapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
