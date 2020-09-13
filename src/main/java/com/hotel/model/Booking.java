package com.hotel.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private long bookingid;
	
	@NotNull(message = "userid is compulsory")
	@Column(name = "userid")
	private int userid;
	
	@NotNull(message = "noOfGuest is compulsory")
	@Column(name = "noofguest")
	private int noOfGuest;
	
	@NotNull(message = "checkinDate is compulsory")
	@Column(name = "checkindate")
	private Date checkinDate;
	
	@NotNull(message = "checkoutDate is compulsory")
	@Column(name = "checkoutdate")
	private Date checkoutDate;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Rooms> rooms = new ArrayList<>();

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public List<Rooms> getComments() {
		return rooms;
	}

	public void setComments(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", userid=" + userid + ", noOfGuest=" + noOfGuest + ", checkinDate="
				+ checkinDate + ", checkoutDate=" + checkoutDate + ", rooms=" + rooms + "]";
	}

	
	
}
