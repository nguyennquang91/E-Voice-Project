package com.csc.model;

import java.util.List;
import com.csc.model.Invoice;

public class InvoiceListWrapper {
	List<Invoice> invoiceList;

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
}
