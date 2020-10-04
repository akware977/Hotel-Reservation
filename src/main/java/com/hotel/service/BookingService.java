package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Booking;
import com.hotel.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public void save(Booking booking) {
		bookingRepository.save(booking);
	}
	
}
