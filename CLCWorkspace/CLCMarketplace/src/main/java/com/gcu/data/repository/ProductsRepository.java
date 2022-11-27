package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {
	
}
