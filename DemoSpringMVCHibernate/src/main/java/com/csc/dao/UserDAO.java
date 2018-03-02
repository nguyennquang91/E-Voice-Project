package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.UserDTO;

public interface UserDAO {

	public void saveOrUpdate(UserDTO u);
	public ArrayList<UserDTO> getAll();
	public void addUser(UserDTO user);
	public void deleteUser(int id);
	public UserDTO getUser(int id);
	public UserDTO updateUser(UserDTO user);
}
