package com.hotel.controller;

import java.sql.Timestamp;
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
import com.hotel.service.RoomTypeService;


@Controller
public class RoomTypeController {

	private static final Logger logger = LoggerFactory.getLogger(RoomTypeController.class);
	
	@Autowired
	RoomTypeService roomTypeService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/roomtype", method=RequestMethod.GET)
	public ModelAndView  roomTypePage() {
		ModelAndView modelAndView = new ModelAndView();
		
		RoomType roomtype = new RoomType();
		List<RoomType> roomtypelist = roomTypeService.getAllRooms();
		
		modelAndView.addObject("roomtypelist", roomtypelist);
		modelAndView.addObject("roomtype", roomtype);
		modelAndView.setViewName("/admin/roomtype");
		
		return  modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/addroomtype", method=RequestMethod.POST)
	public ModelAndView  addRoomTypePage(@Valid RoomType roomtype, BindingResult bindingResult, ModelMap modelMap, Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView();
		
		//check for validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message", "Please correct the error in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			logger.debug("Please correct the error in form");
		} else {
			Date today = new Date();
			Timestamp timestamp = new Timestamp(today.getTime());
			roomtype.setLastCapacityUpdate(timestamp);
			roomTypeService.save(roomtype);			
		}	

		modelAndView.addObject("roomtype", roomtype);
		modelAndView.setViewName("redirect:" +"/roomtype");
		
		return  modelAndView;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/updateroomtype", method=RequestMethod.GET)
	public ModelAndView showUpdateRoomTypeForm(@RequestParam int id) {
		RoomType roomtype = roomTypeService.getRoomTypeByNo(id);

		ModelAndView modelAndView = new ModelAndView();
		List<RoomType> roomtypelist = roomTypeService.getAllRooms();
		
		modelAndView.addObject("roomtypelist", roomtypelist);
		modelAndView.addObject("roomtype", roomtype);
		modelAndView.setViewName("/admin/roomtype");
		return  modelAndView;
	}
	
}
