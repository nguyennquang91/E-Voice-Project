package com.csc.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.Month;

@Repository
@Transactional
public class MonthDAOImpl implements MonthDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Month> getAll() {
		return (ArrayList<Month>) getSessionFactory().getCurrentSession().createQuery("from months").list();
	}

	
	public void addMonth(Month month){
		sessionFactory.getCurrentSession().saveOrUpdate(month);
	}
	
	public void deleteMonth(int id){
		Month month = (Month) sessionFactory.getCurrentSession().load(Month.class, id);
		if (null != month) {
            this.sessionFactory.getCurrentSession().delete(month);
        }
	}
	
	public Month getMonth(int id){
		return (Month) sessionFactory.getCurrentSession().get(Month.class, id);
	}
	
	public Month getMonthByName(String name) {
		String sqlStr = "select id from months u where u.monthname = :name";
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlStr);
		query.setParameter("name", name);
		int monthId = (Integer) query.uniqueResult();
		return this.getMonth(monthId);
	}
	
	public Month updateMonth(Month month){
		sessionFactory.getCurrentSession().update(month);
		return month;
	}
}