package com.hotel.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyUserDetails extends User implements UserDetails {

	
	private static final Logger logger = LoggerFactory
			.getLogger(MyUserDetails.class);
	
	public MyUserDetails(final User user) {
		super(user);
		logger.info("MyUserDetails User ::" + super.getFname());		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPwd();
	}
	
	@Override
    public String getUsername() {
        return super.getUsername();
    }

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
