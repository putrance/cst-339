package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.ProductDataAccess;
import com.gcu.data.UserDataAccess;
import com.gcu.entity.ProductEntity;
import com.gcu.entity.UserEntity;
import com.gcu.model.ProductForm;
import com.gcu.model.ProductModel;
import com.gcu.model.UserModel;

//TODO: Fix data validation error

@Controller
@RequestMapping("/")
public class ProductsController {
	
	@Autowired
	ProductDataAccess service;
	
	@GetMapping("/ProductsAddition")
	public String display(Model model) {
		model.addAttribute("title", "Product Addition Form");
		model.addAttribute("product", new ProductModel());
		model.addAttribute("productForm", new ProductForm());
		return "ProductsAddition";
	}
	@PostMapping("/doProduct")
	public String doProduct(@Valid ProductForm product, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Product Added");
			return "ProductsAddition";
		}
		
		System.out.println(String.format("Form of added products", product.getColor(), product.getSize(), product.getStock()));
		

		List<ProductForm> products = null;
		
		
		if(model.containsAttribute("products")) {
			List<ProductForm> productsList = (List<ProductForm>) model.getAttribute("products");
			if(productsList != null) {
				products = productsList;
			}
		}
		if(products == null) {
			products = new ArrayList<ProductForm>();
		}
		products.add(product);
		
		service.create(new ProductEntity(product.getColor(), product.getSize(), product.getStock()));
		
		
		List<ProductForm> productsList = new ArrayList<ProductForm>();
		productsList.add(new ProductForm(product.getColor(), product.getSize(), product.getStock()));
		
		
		model.addAttribute("title", "My products");
		model.addAttribute("products", products);					
		
		return "Products";
	}

}


