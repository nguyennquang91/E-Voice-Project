package com.csc.model;

import com.csc.model.User;
import java.util.List;

public class UserListWrapper {
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
