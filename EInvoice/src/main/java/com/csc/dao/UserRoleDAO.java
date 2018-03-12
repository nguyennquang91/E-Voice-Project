package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.UserRole;

public interface UserRoleDAO {

	public ArrayList<UserRole> getAll();
	public void addUserRole(UserRole userRole);
	public void deleteUserRole(int id);
	public UserRole getUserRole(int id);
	public UserRole getUserRoleByName(String name);
	public UserRole updateUserRole(UserRole user);
}
