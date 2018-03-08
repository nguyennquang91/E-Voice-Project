package com.csc.service;

import java.util.ArrayList;
import java.util.List;

import com.csc.model.Invoice;

public interface InvoiceService {

	public ArrayList<Invoice> getAll();
	public List<Invoice> getAllByUserId(int userId);
	public void addInvoice(Invoice invoice);
	public void deleteInvoice(int id);
	public Invoice getInvoice(int id);
	public Invoice updateInvoice(Invoice invoice);
}