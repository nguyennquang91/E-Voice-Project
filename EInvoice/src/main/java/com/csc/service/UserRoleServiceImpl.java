package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.UserRoleDAO;
import com.csc.model.UserRole;


@Service
public class UserRoleServiceImpl implements UserRoleService {

	UserRoleDAO userRoleDao;
	
	public UserRoleDAO getUserRoleDao() {
		return userRoleDao;
	}

	@Autowired
	public void setUserRoleDao(UserRoleDAO userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public ArrayList<UserRole> getAll() {
		return getUserRoleDao().getAll();
	}

	public void addUserRole(UserRole userRole){
		getUserRoleDao().addUserRole(userRole);
	}
	
	public void deleteUserRole(int id){
		getUserRoleDao().deleteUserRole(id);
	}
	
	public UserRole getUserRole(int id){
		return getUserRoleDao().getUserRole(id);
	}
	
	public UserRole getUserRoleByName(String name){
		return getUserRoleDao().getUserRoleByName(name);
	}
	
	public UserRole updateUserRole(UserRole userRole){
		return getUserRoleDao().updateUserRole(userRole);
	}
}
