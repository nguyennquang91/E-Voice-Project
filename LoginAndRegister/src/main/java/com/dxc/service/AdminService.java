package com.dxc.service;

import com.dxc.model.Admin;

public interface AdminService {

	public Admin getAdmin(int id);
	public int checkLoginAdmin(String id, String password);
}
