package com.dxc.dao;


import com.dxc.model.User;

public interface UserDao {

	public User getUser(int id);
	public void register(User user);
	public int checkLoginUser(String id, String password);
	
}
