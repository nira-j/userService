package com.user.userservice.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userservice.Dto.SigninDto;
import com.user.userservice.Dto.SignupDto;
import com.user.userservice.model.Role;
import com.user.userservice.model.User;
import com.user.userservice.repository.RoleRepository;
import com.user.userservice.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	@Autowired RoleRepository roleRepository;
	
	public SigninDto getUserDetails(String username) {
		User user=userRepository.findByUsername(username);
		SigninDto signin=new SigninDto();
		
		signin.setFirstname(user.getFirstname());
		signin.setLastname(user.getLastname());
		signin.setId(user.getId());
		signin.setMobileno(user.getMobileno());
		signin.setProfileimage(user.getProfileimage());
		signin.setProfilesignature(user.getProfilesignature());
		signin.setUsername(user.getUsername());
		return signin;
	}
	
public User saveUserDetails(SignupDto userdetails) {
	
	
		User user = new User();
		user.setFirstname(userdetails.getFirstname());
		user.setLastname(userdetails.getLastname());
		user.setEmailid(userdetails.getEmailid());
		user.setMobileno(userdetails.getMobileno());
		user.setPassword(userdetails.getPassword());
		user.setProfileimage(userdetails.getProfileimage());
		user.setProfilesignature(userdetails.getProfilesignature());
		user.setStatus("Y");
		user.setUsername(generateRandomUsername());
		
		Role role=roleRepository.findByRolename(userdetails.getRole());
		
		Set<Role> rol = new HashSet<Role>();
		rol.add(role);
		user.setRoles(rol);
		return userRepository.save(user);
	}

	public static String generateRandomUsername() {
	    String randomUUID = UUID.randomUUID().toString();
	    String username = "user_" + randomUUID;
	    int maxLength =5;
	    if (username.length() > maxLength) {
	        username = username.substring(0, maxLength);
	    }
	    return username;
	}
	
}
