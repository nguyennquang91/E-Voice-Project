package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.UserDao;
import com.dxc.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public User getUser(int id) {
		return getUserDao().getUser(id);
	}

	
	public void register(User user) {
		getUserDao().register(user);
	}

	public int checkLoginUser(String id, String password) {
		 System.out.println("In Service class...Check Login");
         return userDao.checkLoginUser(id, password);
	}


}
