package com.csc.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAll() {
		return (ArrayList<User>) getSessionFactory().getCurrentSession().createQuery("from users").list();
	}

	
	public void addUser(User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void deleteUser(int id){
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
	}
	
	public User getUser(int id){
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	public User updateUser(User user){
		sessionFactory.getCurrentSession().update(user);
		return user;
	}
}