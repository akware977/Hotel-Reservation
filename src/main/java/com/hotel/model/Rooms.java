package com.hotel.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomno")
	private int roomno;
	
	@NotNull(message = "lastCheckoutDate is compulsory")
	@Column(name = "lastCheckoutDate")
	private Date lastCheckoutDate;	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "rooms_roomtype",
	joinColumns = @JoinColumn (name = "roomtypeno"),
	inverseJoinColumns = @JoinColumn (name ="roomno"))
	private RoomType roomType;
	
	
	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public Date getLastCheckoutDate() {
		return lastCheckoutDate;
	}

	public void setLastCheckoutDate(Date lastCheckoutDate) {
		this.lastCheckoutDate = lastCheckoutDate;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Rooms [roomno=" + roomno + ", lastCheckoutDate=" + lastCheckoutDate + ", roomType=" + roomType + "]";
	}
	
	
}
