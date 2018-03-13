package com.csc.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.Type;

@Repository
@Transactional
public class TypeDAOImpl implements TypeDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Type> getAll() {
		return (ArrayList<Type>) getSessionFactory().getCurrentSession().createQuery("from invoice_types").list();
	}

	
	public void addType(Type type){
		sessionFactory.getCurrentSession().saveOrUpdate(type);
	}
	
	public void deleteType(int id){
		Type type = (Type) sessionFactory.getCurrentSession().load(Type.class, id);
		if (null != type) {
            this.sessionFactory.getCurrentSession().delete(type);
        }
	}
	
	public Type getType(int id){
		return (Type) sessionFactory.getCurrentSession().get(Type.class, id);
	}
	
	public Type getTypeByName(String name) {
		String sqlStr = "select id from invoice_types u where u.name = :name";
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlStr);
		query.setParameter("name", name);
		int typeId = (Integer) query.uniqueResult();
		return this.getType(typeId);
	}
	
	public Type updateType(Type type){
		sessionFactory.getCurrentSession().update(type);
		return type;
	}
}