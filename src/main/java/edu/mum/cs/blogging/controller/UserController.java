package edu.mum.cs.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.blogging.model.User;
import edu.mum.cs.blogging.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/user/register")
	public String getRegister() {
		return "user/register";
	}
	
	@PostMapping("/user/register")
	public String register(@ModelAttribute("user")User user) {
		userService.saveUser(user);
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/login")
	public String getLogin() {
		return "user/login";
	}
	
}
