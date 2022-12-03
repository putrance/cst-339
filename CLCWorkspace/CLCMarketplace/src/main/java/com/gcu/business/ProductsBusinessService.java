package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.data.ProductDataAccess;
import com.gcu.entity.OrderEntity;
import com.gcu.entity.ProductEntity;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

public class ProductsBusinessService implements ProductsBusinessInterface {

	@Autowired
	ProductDataAccess service;
	
	@Override
	public void Test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the OrdersBusinessService");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getProducts() {
		// TODO Auto-generated method stub
		List<ProductEntity> productEntity = service.findAll();
		
		List<ProductModel> productDomain = new ArrayList<ProductModel>();
		for(ProductEntity entity : productEntity) {
			productDomain.add(new ProductModel(entity.getColor(), entity.getSize(), entity.getStock()));
		}		
		return productDomain;
	}

	@Override
	public void init() {
		System.out.println("Hello from the OrdersBusinessService init");
		
	}

	@Override
	public void destroy() {
		System.out.println("Hello from the OrdersBusinessService destroy");
		
	}

}
