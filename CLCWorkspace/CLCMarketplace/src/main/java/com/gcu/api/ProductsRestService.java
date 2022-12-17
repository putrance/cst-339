package com.gcu.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.ProductDataAccess;
import com.gcu.entity.ProductEntity;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	@Autowired
	ProductDataAccess service;
	
	@GetMapping(path="/products")
	public ResponseEntity<?> getProducts()
	{
		try
		{
			List<ProductEntity> products = service.findAll();
			if(products == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(products, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/product")
	public ResponseEntity<?> getProductById(@RequestParam(name="productId")int productId) {
		try
		{
			Optional<ProductEntity> product = service.findById(productId);
			if(product == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(product, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
