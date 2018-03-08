package com.dxc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Admin getAdmin(int id) {
		return (Admin) sessionFactory.getCurrentSession().load(Admin.class, id);
	}

	public int checkLoginAdmin(String id, String password) {
		String loginIdentifierStr = id.substring(0, 1);
		
		if(loginIdentifierStr.equals("a")){
		
			String loginNumberPartStr = id.substring(1, id.length());
			int loginNumberPart = Integer.parseInt(loginNumberPartStr);
		
			Admin tempAdmin = this.getAdmin(loginNumberPart);
			System.out.println(tempAdmin);
			if(null != tempAdmin && tempAdmin.getPassword().equalsIgnoreCase(password)){
				return tempAdmin.getId();
			}
			else
				return 0;
			}
		else
			return 0;
	}
}
