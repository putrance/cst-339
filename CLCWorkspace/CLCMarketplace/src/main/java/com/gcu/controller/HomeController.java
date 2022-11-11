package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("/")
	public String printHome(Model model)
	{
		model.addAttribute("title", "Welcome to the CLC Marketplace!");
		return "home";
	}
}