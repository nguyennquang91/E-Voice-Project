package com.csc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.InvoiceDAO;
import com.csc.model.Invoice;


@Service
public class InvoiceServiceImpl implements InvoiceService {

	InvoiceDAO invoiceDao;
	
	public InvoiceDAO getInvoiceDao() {
		return invoiceDao;
	}

	@Autowired
	public void setInvoiceDao(InvoiceDAO invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

	public ArrayList<Invoice> getAll() {
		return getInvoiceDao().getAll();
	}

	public void addInvoice(Invoice invoice){
		getInvoiceDao().addInvoice(invoice);
	}
	
	public void deleteInvoice(int id){
		getInvoiceDao().deleteInvoice(id);
	}
	
	public Invoice getInvoice(int id){
		return getInvoiceDao().getInvoice(id);
	}
	
	public Invoice updateInvoice(Invoice invoice){
		return getInvoiceDao().updateInvoice(invoice);
	}
}
