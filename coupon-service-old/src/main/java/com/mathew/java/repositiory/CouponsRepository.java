package com.mathew.java.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathew.java.entity.Coupon;

public interface CouponsRepository extends JpaRepository<Coupon, Long> {

	Coupon getByCode(String code);

}
