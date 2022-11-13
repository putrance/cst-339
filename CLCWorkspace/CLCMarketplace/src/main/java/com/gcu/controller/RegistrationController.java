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
			model.addAttribute("user", new UserModel());
			model.addAttribute("users", new ArrayList<UserModel>());
			return "register";
		}
		@PostMapping("/doRegister")
		public String doRegister(@Valid UserModel user, BindingResult bindingResult, Model model) {
			
			if(bindingResult.hasErrors()) {
				model.addAttribute("title", "Registration Form");
				//model.addAttribute("user", user);
				return "register";
			}
			
			System.out.println(String.format("Form with Username of %s and Password of %s", user.getUsername(), user.getPassword()));
			

			List<UserModel> users = null;
			//= (List<UserModel>) model.getAttribute("users");
			
			if(model.containsAttribute("users")) {
				List<UserModel> userList = (List<UserModel>) model.getAttribute("users");
				if(userList != null) {
					users = userList;
				}
			}
			if(users == null) {
				users = new ArrayList<UserModel>();
			}
			users.add(user);
			
			//new UserModel(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getUsername(), user.getPassword())
			
			model.addAttribute("title", "My users");
			model.addAttribute("users", users);					
			
			return "registrationConfirmation";
		}
	
}
