package com.coupon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coupon.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
