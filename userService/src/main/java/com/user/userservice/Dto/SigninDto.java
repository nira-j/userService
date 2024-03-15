package com.user.userservice.Dto;

import lombok.Data;

@Data
public class SigninDto {
	
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String mobileno;
	private String profileimage;
	private String profilesignature;
}
