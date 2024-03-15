package com.user.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.userservice.Dto.SigninDto;
import com.user.userservice.Dto.SignupDto;
import com.user.userservice.model.User;
import com.user.userservice.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping(value="/user/{username}")
	public SigninDto signin(@PathVariable String username) {
		return userService.getUserDetails(username);
	}
	
	@PostMapping(value="/user/signup")
	public User signupDto(@RequestBody SignupDto signupdetails) {
		return userService.saveUserDetails(signupdetails);
	}
	
}
