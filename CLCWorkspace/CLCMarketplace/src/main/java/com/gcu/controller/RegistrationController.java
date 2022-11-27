package com.gcu.controller;
import com.gcu.data.UserDataAccess;
import com.gcu.entity.UserEntity;
import com.gcu.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {
		
		@Autowired
		UserDataAccess service;
		
		@Autowired
		private  PasswordEncoder passwordEncoder;
		
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
			
			String encodedPassword = passwordEncoder.encode(registration.getPassword());
			
			service.create(new UserEntity(registration.getFirstName(), registration.getLastName(),
					registration.getEmail(), registration.getPhoneNumber(), 
					registration.getUsername(), encodedPassword));
			
			
			List<UserModel> users = new ArrayList<UserModel>();
			users.add(new UserModel(registration.getFirstName(), registration.getLastName(),
					registration.getEmail(), registration.getPhoneNumber(), 
					registration.getUsername(),encodedPassword));
			
			
			model.addAttribute("title", "Registration Complete");
			model.addAttribute("users", users);	
			
			
			
			return "registrationConfirmation";
		}
	
}
