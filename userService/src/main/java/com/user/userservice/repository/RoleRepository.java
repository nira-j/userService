package com.user.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.userservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByRolename(String rolename);
}
