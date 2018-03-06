package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.UserDAO;
import com.csc.model.User;


@Service
public class UserServiceImpl implements UserService {

	UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public ArrayList<User> getAll() {
		return getUserDao().getAll();
	}

	public void addUser(User user){
		getUserDao().addUser(user);
	}
	
	public void deleteUser(int id){
		getUserDao().deleteUser(id);
	}
	
	public User getUser(int id){
		return getUserDao().getUser(id);
	}
	
	public User updateUser(User user){
		return getUserDao().updateUser(user);
	}
}
