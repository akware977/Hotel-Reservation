package com.hotel.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public Roles getRolesByRolename(String rolename){
		return roleRepository.findByrolename(rolename);
	}
	
	public Set<Roles> getRoles(){
		Set<Roles> roles = new HashSet<>();
		roles.add(roleRepository.findByrolename("ROLE_User"));		
		return roles;
	}
}
