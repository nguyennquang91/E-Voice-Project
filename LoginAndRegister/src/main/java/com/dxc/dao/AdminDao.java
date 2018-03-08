package com.dxc.dao;

import com.dxc.model.Admin;

public interface AdminDao {

	public Admin getAdmin(int id);
	public int checkLoginAdmin(String id, String password);
}
