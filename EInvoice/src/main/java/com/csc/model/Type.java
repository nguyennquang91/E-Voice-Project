package com.csc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="invoice_types")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="type")
	private List<Invoice> invoiceList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

}
