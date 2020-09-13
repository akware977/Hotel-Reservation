package com.hotel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private long userid;
	
	//@NotNull(message = "Username is compulsory")
	@Column(name = "username")
	private String username;
	
	@NotNull(message = "Password is compulsory")
	@Size(min=4, message="Password shoulld be atleast {min} Character")
	@Column(name = "password")
	private String pwd;
	
	@NotNull(message = "First name is compulsory")
	@Column(name = "fname")
	private String fname;
	
	@NotNull(message = "Last name is compulsory")
	@Column(name = "lname")
	private String lname;
	
	@NotNull(message = "Email is compulsory")
	@Email(message = "email is invalid")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "mobile is compulsory")
	@Email(message = "mobile is invalid")
	@Column(name = "mobile")
	private String mobile;

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn (name = "userid"),
	inverseJoinColumns = @JoinColumn (name ="roleid"))
	private Set<Roles> roles;
	
	
	public User() {}
	
	public User(User user) {
		this.username = user.getUsername();
		this.pwd = user.getPwd();
		this.fname = user.getFname();
		this.lname = user.getLname();
		this.email = user.getEmail();
		this.mobile = user.getMobile();
		this.roles = user.getRoles();
	}

	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", pwd=" + pwd + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", mobile=" + mobile + ", roles=" + roles + "]";
	}
	
}
