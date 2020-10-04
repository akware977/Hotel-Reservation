package com.hotel.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomtypeno")
	private int roomtypeno;
	
	@NotNull(message = "Room type is compulsory")
	@Column(name = "roomtype")
	private String roomtype;
	
	@NotNull(message = "Capacity is compulsory")
	@Column(name = "capacity")
	private int capacity;
	
	@NotNull(message = "lastCapacityUpdate is compulsory")
	@Column(name = "lastCapacityUpdate")
	private Timestamp lastCapacityUpdate;

	public int getRoomtypeno() {
		return roomtypeno;
	}

	public void setRoomtypeno(int roomtypeno) {
		this.roomtypeno = roomtypeno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Timestamp getLastCapacityUpdate() {
		return lastCapacityUpdate;
	}

	public void setLastCapacityUpdate(Timestamp lastCapacityUpdate) {
		this.lastCapacityUpdate = lastCapacityUpdate;
	}

	@Override
	public String toString() {
		return "RoomType [roomtypeno=" + roomtypeno + ", roomtype=" + roomtype + ", capacity=" + capacity
				+ ", lastCapacityUpdate=" + lastCapacityUpdate + "]";
	}
	
	
	
	

}
