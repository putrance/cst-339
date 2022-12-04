package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.data.ProductDataAccess;
import com.gcu.data.UserDataAccess;
import com.gcu.data.repository.ProductsRepository;
import com.gcu.entity.ProductEntity;
import com.gcu.entity.UserEntity;
import com.gcu.model.ProductModel;

//TODO: Fix data validation error

@Controller
@RequestMapping("/")
public class ProductsController {
	
	private ProductsRepository productsRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public ProductsController(ProductsRepository ProductsRepository, DataSource dataSource, JdbcTemplate jdbcTemplateObject) {
		this.productsRepository = ProductsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	@Autowired
	ProductDataAccess service;
	
	@Autowired
	private ProductsBusinessInterface productinterface;
	
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
		
		System.out.println(String.format("Form of added products", product.getColor(), product.getSize(), product.getStock(), product.getId()));
		

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
		
		service.create(new ProductEntity(product.getColor(), product.getSize(), product.getStock(), product.getId()));
		
		model.addAttribute("title", "My products");
		model.addAttribute("products", products);					
		
		return "Products";
	}
	
	@RequestMapping(value = "/delete_product", method = RequestMethod.GET)
	public String handleDeleteProduct(@RequestParam(name="productId")String productId) {
		
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			jdbcTemplateObject.update(sql,
					productId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
		System.out.println(productinterface.getProducts());
	    System.out.println(productId);
	    System.out.println("test deleting product");
	    return "redirect:/";
	}
	
	
	//
	//
	//To be completed, Flow -> Pass ID from Thymeleaf, Get Object with ID, Send user to input form with prepopulated info, Submit triggers /doProductUpdate to perform SQL UPDATE statement against items matching id
	@RequestMapping(value = "/edit_product", method = RequestMethod.GET)
	public String handleeditProduct(@RequestParam(name="productId")int productId) {
		System.out.println(productId);
	    System.out.println("test editing product");
	    
	    ProductModel product = new ProductModel();
	    
	    product.setId(productId);
	    
	    return "ProductsUpdate";
	}
	
	@PostMapping("/doProductUpdate")
	public String doProductUpdate(@Valid ProductModel product, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Update Product");
			return "ProductsUpdate";
		}
		
		System.out.println(String.format("Form of update products", product.getColor(), product.getSize(), product.getStock(), product.getId()));
		
		
		model.addAttribute("title", "Update Product");
		model.addAttribute("product", product);					
		
		return "redirect:/";
	}

}


