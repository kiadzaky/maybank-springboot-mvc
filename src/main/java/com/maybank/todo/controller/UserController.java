package com.maybank.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maybank.todo.model.User;
import com.maybank.todo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService service;
	@RequestMapping(value = "/")
	public String index(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "user/login";
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("user") User user, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/login");
		User userobj =  service.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userobj != null) {
//			return "redirect:/product/";	
			ModelAndView andView = new ModelAndView("redirect:/product/");
			return andView;
		}else {
			modelAndView.addObject("gagal_login", "<p>GAGAL LOGIN</p>");
			System.out.println(modelAndView);
			return modelAndView;
		}
		
	}
}
