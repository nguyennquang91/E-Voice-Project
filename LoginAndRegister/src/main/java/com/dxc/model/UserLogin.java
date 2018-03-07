package com.dxc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLogin {

	
	@NotEmpty
	private String userid;
	
	@NotEmpty
	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
