package com.product.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{

	List<Product> findByName(String name);
	List<Product> findByNameAndPrice(String name,Double price);

}
