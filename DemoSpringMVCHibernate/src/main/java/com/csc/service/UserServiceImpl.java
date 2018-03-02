package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.UserDAO;
import com.csc.model.UserDTO;


@Service
public class UserServiceImpl implements UserService {

	UserDAO u;
	

	public UserDAO getU() {
		return u;
	}

	@Autowired
	public void setU(UserDAO u) {
		this.u = u;
	}

	public void saveOrUpdate(UserDTO u) {
		getU().saveOrUpdate(u);
	}

	@Override
	public ArrayList<UserDTO> getAll() {
		return getU().getAll();
	}

	@Override
	public void addUser(UserDTO user){
		getU().addUser(user);
	}
	
	@Override
	public void deleteUser(int id){
		getU().deleteUser(id);
	}
	
	public UserDTO getUser(int id){
		return getU().getUser(id);
	}
	
	public UserDTO updateUser(UserDTO user){
		return getU().updateUser(user);
	}
}
