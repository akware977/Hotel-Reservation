package com.hotel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.Booking;
import com.hotel.service.BookingService;

@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;
	
	//need permission only for user
	@RequestMapping(value = "/searchrooms", method=RequestMethod.POST)
	public ModelAndView  addbooking(@Valid Booking booking, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(booking.toString());
		
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("message","please correct the error in form");
			modelMap.addAttribute(modelMap);
			logger.debug("Please correct the error in Booking form");
		}
		
		modelAndView.addObject("booking", booking);
		modelAndView.setViewName("/user/avaliablerooms"); 
		
		return  modelAndView;
	}
	
}
