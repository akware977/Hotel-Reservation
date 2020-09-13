package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.model.MyUserDetails;
import com.hotel.model.User;
import com.hotel.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userRepository.findByEmail(email);
		
		optionalUser
        	.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUser
				.map(MyUserDetails::new).get();
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}

	public User findUserbyUserEmail(String email) {		
		return userRepository.findByEmail(email).get();		
	}

	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	public User addUser(User user){
		user.setPwd(encoder.encode(user.getPwd()));
		return userRepository.save(user);
	}
}
