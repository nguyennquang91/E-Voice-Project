package com.csc.dao;

import java.util.ArrayList;

import com.csc.model.Invoice;

public interface InvoiceDAO {

	public ArrayList<Invoice> getAll();
	public void addInvoice(Invoice invoice);
	public void deleteInvoice(int id);
	public Invoice getInvoice(int id);
	public Invoice updateInvoice(Invoice invoice);
}
