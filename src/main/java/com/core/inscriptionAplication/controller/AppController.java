package com.core.inscriptionAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.core.inscriptionAplication.entity.User;
import com.core.inscriptionAplication.service.UserService;



@Controller
public class AppController {

	@Autowired 
	UserService userService;
	private User user = new User();
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
		
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		try {
		return "admin";}
		catch(Exception e) {
			return "login";
		}
	}
	
	@GetMapping("/error")
         public String error() {
        	 return "index";
         }
	@GetMapping("/hola")
	public String getUserForm(Model model) {
		model.addAttribute("userForm", new User());
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("listTab","active");
		return "userlist";
}
}

