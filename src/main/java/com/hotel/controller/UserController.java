package com.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.Booking;
import com.hotel.model.Rooms;
import com.hotel.model.User;
import com.hotel.service.MyUserDetailsService;
import com.hotel.service.RoleService;
import com.hotel.service.RoomService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	MyUserDetailsService userdetailService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RoomService roomService; 
	
	@RequestMapping(value = "/user_index", method=RequestMethod.GET)
	public ModelAndView  loginPage() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		Booking booking = new Booking();
		List<Rooms> roomslist = roomService.getAllRooms();
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("booking", booking);
		modelAndView.addObject("roomslist",roomslist);
		modelAndView.setViewName("/user/index");
		
		return  modelAndView;
	}
	
	
}
