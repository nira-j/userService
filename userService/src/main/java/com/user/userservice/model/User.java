package com.user.userservice.model;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private String mobileno;
	private String status;
	private String profileimage;
	private String profilesignature;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="user_roles",
			joinColumns=@JoinColumn(name="userid", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="roleid", referencedColumnName="id")
			)
	private Set<Role> roles = new HashSet<>();
	

}
