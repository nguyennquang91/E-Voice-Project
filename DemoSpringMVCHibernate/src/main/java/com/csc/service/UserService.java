package com.csc.service;

import java.util.ArrayList;

import com.csc.model.UserDTO;

public interface UserService {

	public void saveOrUpdate(UserDTO u);
	public ArrayList<UserDTO> getAll();
	public void addUser(UserDTO user);
	public void deleteUser(int id);
	public UserDTO getUser(int id);
	public UserDTO updateUser(UserDTO user);
}