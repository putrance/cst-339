package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.entity.UserEntity;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/")
public class ProductsController {
	@GetMapping("/ProductsAddition")
	public String display(Model model) {
		model.addAttribute("title", "Product Addition Form");
		model.addAttribute("product", new ProductModel());
		model.addAttribute("products", new ArrayList<ProductModel>());
		return "ProductsAddition";
	}
	@PostMapping("/doProduct")
	public String doProduct(@Valid ProductModel product, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Product Added");
			return "ProductsAddition";
		}
		
		System.out.println(String.format("Form of added products", product.getColor(), product.getSize(), product.getStock()));
		

		List<ProductModel> products = null;
		
		
		if(model.containsAttribute("products")) {
			List<ProductModel> productsList = (List<ProductModel>) model.getAttribute("products");
			if(productsList != null) {
				products = productsList;
			}
		}
		if(products == null) {
			products = new ArrayList<ProductModel>();
		}
		products.add(product);
		
		
		
		model.addAttribute("title", "My products");
		model.addAttribute("products", products);					
		
		return "Products";
	}

}


