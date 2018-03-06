package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.User;

public interface UserDAO {

	public ArrayList<User> getAll();
	public void addUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public User updateUser(User user);
}
