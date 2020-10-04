package com.hotel.controller;



import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.RoomType;
import com.hotel.model.Rooms;
import com.hotel.service.RoomService;
import com.hotel.service.RoomTypeService;

@Controller
public class RoomController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomTypeService roomTypeService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/rooms", method=RequestMethod.GET)
	public ModelAndView  roomsPage() {
		ModelAndView modelAndView = new ModelAndView();
		
		Rooms rooms = new Rooms();
		List<RoomType> roomTypelist = roomTypeService.getAllRooms();
		List<Rooms> roomslist = roomService.getAllRooms();
		
		modelAndView.addObject("roomslist", roomslist);
		modelAndView.addObject("roomTypelist", roomTypelist);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("/admin/rooms");
		
		return  modelAndView;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/addrooms", method=RequestMethod.POST)
	public ModelAndView  addRooms(@Valid Rooms rooms, BindingResult bindingResult, ModelMap modelMap, Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView();
		
		//check for validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message", "Please correct the error in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			logger.debug("Please correct the error in form");
		} else {
			Date today = new Date();			
			rooms.setLastCheckoutDate(today);
			roomService.save(rooms);			
		}	

		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("redirect:" +"/rooms");
		
		return  modelAndView;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/updaterooms", method=RequestMethod.GET)
	public ModelAndView showUpdateRoomsForm(@RequestParam int id) {
		Rooms rooms = roomService.getRoomByNo(id);

		ModelAndView modelAndView = new ModelAndView();
		List<Rooms> roomslist = roomService.getAllRooms();
		List<RoomType> roomTypelist = roomTypeService.getAllRooms();
		
		modelAndView.addObject("roomslist", roomslist);
		modelAndView.addObject("roomTypelist", roomTypelist);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("/admin/rooms");
		return  modelAndView;
	}
	
	
}
