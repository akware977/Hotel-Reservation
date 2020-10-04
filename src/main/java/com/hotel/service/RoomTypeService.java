package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.RoomType;
import com.hotel.repository.RoomTypeRepository;

@Service
public class RoomTypeService {

	@Autowired
	RoomTypeRepository roomTypeRepository;
	
	public List<RoomType> getAllRooms(){
		return roomTypeRepository.findAll();
	}
	
	public RoomType getRoomTypeByNo(int roomtypeno) {
		return roomTypeRepository.findByroomtypeno(roomtypeno);
	}
	
	
	
	public void save(RoomType roomtype) {
		roomTypeRepository.save(roomtype);
	}
	
	
	
}
