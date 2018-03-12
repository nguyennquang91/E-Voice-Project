package com.csc.dao;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.UserRole;

@Repository
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<UserRole> getAll() {
		return (ArrayList<UserRole>) getSessionFactory().getCurrentSession().createQuery("from user_roles").list();
	}

	public void addUserRole(UserRole userRole){
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
	}
	
	public void deleteUserRole(int id){
		UserRole userRole = (UserRole) sessionFactory.getCurrentSession().load(UserRole.class, id);
		if (null != userRole) {
            this.sessionFactory.getCurrentSession().delete(userRole);
        }
	}
	
	public UserRole getUserRole(int id){
		return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
	}
	

	public UserRole getUserRoleByName(String name){
		String sqlStr = "select id from user_roles r where r.username = :name";
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlStr);
		query.setParameter("name", name);
		int id = (Integer) query.uniqueResult();
		return this.getUserRole(id);
	}
	
	public UserRole updateUserRole(UserRole userRole){
		sessionFactory.getCurrentSession().update(userRole);
		return userRole;
	}
}
