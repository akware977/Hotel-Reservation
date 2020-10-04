package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

	Rooms findByroomno(int roomno);

}
