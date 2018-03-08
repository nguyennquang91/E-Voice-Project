package com.dxc.service;

import com.dxc.model.User;

public interface UserService {

	public User getUser(int id);
	public void register(User user);
	public int checkLoginUser(String id, String password);
	
}
