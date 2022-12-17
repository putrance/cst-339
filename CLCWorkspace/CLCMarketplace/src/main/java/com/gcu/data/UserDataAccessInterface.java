package com.gcu.data;

import java.util.List;
import java.util.Optional;

import com.gcu.entity.ProductEntity;

public interface UserDataAccessInterface <T> {
	public List<T> findAll();
	public Optional<ProductEntity> findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
