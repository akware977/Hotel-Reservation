package com.hotel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.User;
import com.hotel.service.MyUserDetailsService;
import com.hotel.service.RoleService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	MyUserDetailsService userdetailService;
	
	@Autowired
	RoleService roleService;
	
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	@RequestMapping(value = "/adduser", method=RequestMethod.POST)
	public ModelAndView  addUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, Authentication authentication) {		
		ModelAndView modelAndView = new ModelAndView();
		
		//check for validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message", "Please correct the error in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			logger.debug("Please correct the error in form");
		} else {
			//String username = authentication.getName();
				
			//DB Operation
			userdetailService.addUser(user);
			//adminlogService.addLog(user.getUserid(), user.getUsername() +" user Added by " + username);
			logger.info(user.getUsername() + " => Admin Added user.");
		}		
		
		modelAndView.setViewName("redirect:"+"/user"); //  /admin/news.jsp
		return  modelAndView;
	}

	
}
