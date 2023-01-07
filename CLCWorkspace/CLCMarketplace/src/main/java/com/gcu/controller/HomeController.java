package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessInterface;

//Homepage controller
@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@GetMapping("/")
	public String printHome(Model model)
	{				
		// Return models on home.html homepage view
		model.addAttribute("title", "Welcome to the CLC Marketplace!");
		model.addAttribute("shirts", service.getProducts());
		return "home";
	}
}
