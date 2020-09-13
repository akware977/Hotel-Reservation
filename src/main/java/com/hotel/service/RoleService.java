package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Roles;
import com.hotel.repository.RolesRepository;

@Service
public class RoleService {

	@Autowired
	RolesRepository roleRepository;
	
	public List<Roles> getAllRoles(){
		return roleRepository.findAll();
	}
}
