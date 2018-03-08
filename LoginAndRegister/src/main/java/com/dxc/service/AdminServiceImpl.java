package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.AdminDao;
import com.dxc.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	AdminDao adminDao;
	
	
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin getAdmin(int id) {
		return getAdminDao().getAdmin(id);
	}

	public int checkLoginAdmin(String id, String password) {
		return adminDao.checkLoginAdmin(id, password);
	}

	
}
