package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductDataAccess;
import com.gcu.entity.ProductEntity;
import com.gcu.model.ProductModel;

//Products Service interface
public class ProductsBusinessService implements ProductsBusinessInterface {

	@Autowired
	ProductDataAccess service;
	
	@Override
	public void Test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the OrdersBusinessService");
	}
	//get products method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntity = service.findAll();
		
		List<ProductModel> productDomain = new ArrayList<ProductModel>();
		for(ProductEntity entity : productEntity) {
			productDomain.add(new ProductModel(entity.getColor(), entity.getSize(), entity.getStock(), entity.getId()));
		}		
		return productDomain;
	}
	//Initiate 
	@Override
	public void init() {
		System.out.println("Hello from the OrdersBusinessService init");
		
	}
	//destroy
	@Override
	public void destroy() {
		System.out.println("Hello from the OrdersBusinessService destroy");
		
	}
	//delete products returns null as they are no longer a product after deletion
	@Override
	public List<ProductModel> deleteProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
