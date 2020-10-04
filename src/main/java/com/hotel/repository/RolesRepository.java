package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

	public Roles findByrolename(String rolename);
	
	
}
