package com.hotel.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.Roles;
import com.hotel.model.User;
import com.hotel.service.MyUserDetailsService;
import com.hotel.service.RoleService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	MyUserDetailsService userdetailService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/addadmin", method=RequestMethod.POST)
	public ModelAndView  addAdminUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView();
		Roles role = roleService.getRolesByRolename("ROLE_ADMIN");
		Set<Roles> roles = new HashSet<>();
		
		//check for validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message", "Please correct the error in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			logger.debug("Please correct the error in form");
		} else {		
			roles.add(role);
			user.setRoles(roles);
			userdetailService.addUser(user);
		}		
		
		modelAndView.setViewName("redirect:"+"/login"); //  /login.jsp
		return  modelAndView;
	}
		
	@RequestMapping(value = "/admin_index", method=RequestMethod.GET)
	public ModelAndView  loginPage() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/admin/index"); //  /login.jsp
		
		return  modelAndView;
	}
	
	@RequestMapping(value = "/adduser", method=RequestMethod.POST)
	public ModelAndView  addUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, Authentication authentication) {		
		ModelAndView modelAndView = new ModelAndView();
		Roles role = roleService.getRolesByRolename("ROLE_User");
		Set<Roles> roles = new HashSet<>();
		
		//check for validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message", "Please correct the error in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			logger.debug("Please correct the error in form");
		} else {
			//String username = authentication.getName();
			
			roles.add(role);
			user.setRoles(roles);
			userdetailService.addUser(user);
		}		
		
		modelAndView.setViewName("redirect:"+"/login"); //  /login.jsp
		return  modelAndView;
	}
	
	@RequestMapping(value = "/adminuser", method=RequestMethod.GET)
	public ModelAndView  adminUserPage() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();

		user.setRoles(roleService.getRoles());
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/admin/adminuser"); //  /admin/adminuser
		
		return  modelAndView;
	}	
	
}
