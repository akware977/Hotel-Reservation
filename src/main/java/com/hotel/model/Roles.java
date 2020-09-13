package com.hotel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	private int roleid;
	private String rolename;

	public Roles(String rolename) {
		this.rolename = rolename;
	}

	public Roles() {}

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
