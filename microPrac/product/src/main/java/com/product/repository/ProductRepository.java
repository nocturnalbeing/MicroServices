package com.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByName(String name);

}
