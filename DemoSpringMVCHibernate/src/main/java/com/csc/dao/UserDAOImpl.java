package com.csc.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.UserDTO;

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

	
	public void saveOrUpdate(UserDTO u) {
		getSessionFactory().getCurrentSession().saveOrUpdate(u);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserDTO> getAll() {
		return (ArrayList<UserDTO>) getSessionFactory().getCurrentSession().createQuery("from users").list();
	}

	public void addUser(UserDTO user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void deleteUser(int id){
		UserDTO user = (UserDTO) sessionFactory.getCurrentSession().load(UserDTO.class, id);
	}
	
	public UserDTO getUser(int id){
		return (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, id);
	}
	
	@Override
	public UserDTO updateUser(UserDTO user){
		sessionFactory.getCurrentSession().update(user);
		return user;
	}
}
