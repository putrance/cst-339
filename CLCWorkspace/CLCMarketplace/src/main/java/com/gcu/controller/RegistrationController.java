package com.gcu.controller;
import com.gcu.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {
		@GetMapping("/register")
		public String display(Model model) {
			model.addAttribute("title", "Registration Form");
			model.addAttribute("registrationForm", new RegistrationForm());
			//model.addAttribute("users", new ArrayList<UserModel>());
			return "register";
		}
		@PostMapping("/doRegister")
		public String doRegister(@Valid RegistrationForm registration, BindingResult bindingResult, Model model) {
			
			if(bindingResult.hasErrors()) {
				model.addAttribute("title", "Registration Form");
				//model.addAttribute("user", user);
				return "register";
			}
			
			List<UserModel> users = new ArrayList<UserModel>();
			users.add(new UserModel(registration.getFirstName(), registration.getLastName(),
					registration.getEmail(), registration.getPhoneNumber(), 
					registration.getUsername(), registration.getPassword()));
			
			
			model.addAttribute("title", "Registration Complete");
			model.addAttribute("users", users);					
			
			return "registrationConfirmation";
		}
	
}
