package com.dxc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {


	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUser(int id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	public void register(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	public int checkLoginUser(String id, String password) {
		String loginIdentifierStr = id.substring(0, 1);
		
		if(loginIdentifierStr.equals("u")){
		
			String loginNumberPartStr = id.substring(1, id.length());
			int loginNumberPart = Integer.parseInt(loginNumberPartStr);
		
			User tempUser = this.getUser(loginNumberPart);
			System.out.println(tempUser);
			if(null != tempUser && tempUser.getPassword().equalsIgnoreCase(password)){
				return tempUser.getId();
			}
			else
				return 0;
			}
		else
			return 0;
	}



}

	

	

	


