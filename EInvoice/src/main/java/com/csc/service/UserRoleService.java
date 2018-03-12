package com.csc.service;

import java.util.ArrayList;

import com.csc.model.UserRole;

public interface UserRoleService {

	public ArrayList<UserRole> getAll();
	public void addUserRole(UserRole userRole);
	public void deleteUserRole(int id);
	public UserRole getUserRole(int id);
	public UserRole getUserRoleByName(String name);
	public UserRole updateUserRole(UserRole userRole);
}