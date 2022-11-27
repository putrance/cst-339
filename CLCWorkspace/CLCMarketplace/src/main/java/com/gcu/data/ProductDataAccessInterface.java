package com.gcu.data;

import java.util.List;

public interface ProductDataAccessInterface <T> {
	public List<T> findAll();
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
