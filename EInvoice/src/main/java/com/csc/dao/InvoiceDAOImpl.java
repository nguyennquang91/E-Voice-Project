package com.csc.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameterValue;
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