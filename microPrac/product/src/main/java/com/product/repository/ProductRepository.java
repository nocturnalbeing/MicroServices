package com.product.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	

}
