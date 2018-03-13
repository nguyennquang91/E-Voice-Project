package com.csc.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.Year;

@Repository
@Transactional
public class YearDAOImpl implements YearDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Year> getAll() {
		return (ArrayList<Year>) getSessionFactory().getCurrentSession().createQuery("from years").list();
	}

	
	public void addYear(Year year){
		sessionFactory.getCurrentSession().saveOrUpdate(year);
	}
	
	public void deleteYear(int id){
		Year year = (Year) sessionFactory.getCurrentSession().load(Year.class, id);
		if (null != year) {
            this.sessionFactory.getCurrentSession().delete(year);
        }
	}
	
	public Year getYear(int id){
		return (Year) sessionFactory.getCurrentSession().get(Year.class, id);
	}
	
	public Year getYearByValue(int value) {
		String sqlStr = "select id from years u where u.value = :value";
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlStr);
		query.setParameter("value", value);
		int yearId = (Integer) query.uniqueResult();
		return this.getYear(yearId);
	}
	
	public Year updateYear(Year year){
		sessionFactory.getCurrentSession().update(year);
		return year;
	}
}