package com.csc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="user_role")
	private String userRole;
}