package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.User;

@Controller
public class AuthController {

	@RequestMapping(value = "/", method=RequestMethod.GET) 
	public ModelAndView homePage() { 
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("redirect:"+"/login");
	  return modelAndView; 
	}
	 
	
	@RequestMapping(value = "/403", method=RequestMethod.GET)
	public ModelAndView  notAuthorrized() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/403"); //  /403.jsp
		return  modelAndView;
	}
	
	@RequestMapping(value = "/about", method=RequestMethod.GET)
	public ModelAndView  aboutPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/about"); //  /about.jsp
		return  modelAndView;
	}

	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView  loginPage() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("login"); //  /login.jsp
		
		return  modelAndView;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public ModelAndView  registerPage() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register"); //  /register.jsp
		
		return  modelAndView;
	}
	
	
}
