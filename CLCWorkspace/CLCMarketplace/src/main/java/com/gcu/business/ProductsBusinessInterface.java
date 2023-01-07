package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

//Products interface
public interface ProductsBusinessInterface {
	public void Test();
	public List<ProductModel> getProducts();
	public List<ProductModel> deleteProducts();
	public void init();
	public void destroy();
}
