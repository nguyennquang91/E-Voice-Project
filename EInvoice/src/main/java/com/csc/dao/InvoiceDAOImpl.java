package com.csc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.model.Invoice;

@Repository
@Transactional
public class InvoiceDAOImpl implements InvoiceDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Invoice> getAll() {
		return (ArrayList<Invoice>) getSessionFactory().getCurrentSession().createQuery("from invoices").list();
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getAllByUserId(int userId){
		String sqlStr = "from invoices v where v.userId = :user_id";
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlStr);
		query.setParameter("user_id", userId);
		return query.list();
	}
	
	public void addInvoice(Invoice invoice){
		sessionFactory.getCurrentSession().saveOrUpdate(invoice);
	}
	
	public void deleteInvoice(int id){
		Invoice invoice = (Invoice) sessionFactory.getCurrentSession().load(Invoice.class, id);
		if (null != invoice) {
            this.sessionFactory.getCurrentSession().delete(invoice);
        }
	}
	
	public Invoice getInvoice(int id){
		return (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, id);
	}
	
	public Invoice updateInvoice(Invoice invoice){
		sessionFactory.getCurrentSession().update(invoice);
		return invoice;
	}
}