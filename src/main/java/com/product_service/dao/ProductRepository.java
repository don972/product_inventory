package com.product_service.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.product_service.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	public Optional<Product> findByPname(String pname);
}
