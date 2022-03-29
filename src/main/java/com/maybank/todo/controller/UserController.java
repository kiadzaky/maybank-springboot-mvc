package com.maybank.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		model.addAttribute("gagal_login",null);
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		User userobj =  service.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userobj != null) {
			ModelAndView andView = new ModelAndView("redirect:/product/");
			return andView;
		}else {
			modelAndView.addObject("gagal_login", "GAGAL LOGIN");
			System.out.println(modelAndView);
			
		}
		return modelAndView;
	}
}
