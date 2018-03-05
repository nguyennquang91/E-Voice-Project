
package com.csc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invoice_id")
	private int invoiceId;
	
	@Column(name = "invoice_type")
	private String invoiceType;
	
	@Column(name = "invoice_money")
	private int invoiceMoney;
	
	@Column(name="invoice_vat")
	private int invoiceVat;

	@Column(name="invoice_month")
	private int invoiceMonth;
	
	@Column(name="invoice_year")
	private int invoiceYear;
	
	@Column(name="user_id")
	private int userId;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public int getInvoiceMoney() {
		return invoiceMoney;
	}

	public void setInvoiceMoney(int invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}

	public int getInvoiceVat() {
		return invoiceVat;
	}

	public void setInvoiceVat(int invoiceVat) {
		this.invoiceVat = invoiceVat;
	}

	public int getInvoiceMonth() {
		return invoiceMonth;
	}

	public void setInvoiceMonth(int invoiceMonth) {
		this.invoiceMonth = invoiceMonth;
	}

	public int getInvoiceYear() {
		return invoiceYear;
	}

	public void setInvoiceYear(int invoiceYear) {
		this.invoiceYear = invoiceYear;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}