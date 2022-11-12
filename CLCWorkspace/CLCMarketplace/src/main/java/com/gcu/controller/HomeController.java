package com.gcu.controller;

import java.util.List;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.ShirtModel;

//Homepage controller
@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("/")
	public String printHome(Model model)
	{
		// Create some shirts to populate table on homepage (To be updated with DB Query)
		List<ShirtModel> shirts = new ArrayList<ShirtModel>();
		shirts.add(new ShirtModel("blue", "small", 2));
		shirts.add(new ShirtModel("green", "medium", 3));
		shirts.add(new ShirtModel("white", "x-large", 4));
		shirts.add(new ShirtModel("red", "x-small", 6));
		shirts.add(new ShirtModel("purple", "large", 10));
		
		// Return models on home.html homepage view
		model.addAttribute("title", "Welcome to the CLC Marketplace!");
		model.addAttribute("shirts", shirts);
		return "home";
	}
}
