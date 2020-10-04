package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Rooms;
import com.hotel.repository.RoomsRepository;

@Service
public class RoomService {

	@Autowired
	RoomsRepository roomsRepository;
	
	public List<Rooms> getAllRooms(){
		return roomsRepository.findAll();
	}
	
	public Rooms getRoomByNo(int roomno) {
		return roomsRepository.findByroomno(roomno);
	}
	
		
	public void save(Rooms rooms) {
		roomsRepository.save(rooms);
	}
	
}
