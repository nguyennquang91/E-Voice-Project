package com.csc.daotest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.dao.InvoiceDAO;
import com.csc.dao.MonthDAO;
import com.csc.dao.TypeDAO;
import com.csc.dao.UserDAO;
import com.csc.dao.YearDAO;
import com.csc.model.Invoice;
import com.csc.model.Month;
import com.csc.model.Type;
import com.csc.model.User;
import com.csc.model.Year;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class InvoiceTest {

	@Autowired
	UserDAO userDao;

	@Autowired
	InvoiceDAO invoiceDao;

	@Autowired
	TypeDAO typeDao;

	@Autowired
	MonthDAO monthDao;

	@Autowired
	YearDAO yearDao;

	// @Test
	public void testAddType() {
		try {
			String[] typeList = { "Electric", "Water", "Telephone", "Internet" };
			User user = userDao.getUser(12);
			if (user != null) {
				for (String t : typeList) {
					Type type = new Type();
					type.setName(t);
					type.setUser(user);
					typeDao.addType(type);
				}
			} else
				System.out.println("KHONG ADD DUOC INVOICE_TYPE VI USER KHONG CO TON TAI !!!");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testDeleteType() {
		try {
			typeDao.deleteType(32);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testGetInvoice() {
		try {
			Invoice invoice = invoiceDao.getInvoice(9);
			Assert.assertNotNull(invoice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	//@Test
	public void testAddInvoice() {
		try {
			List<Type> type = typeDao.getAllByUserId(12);
			List<Month> month = monthDao.getAll();
			List<Year> year = yearDao.getAll();
			User user = userDao.getUser(12);
			if (type != null) {
				Invoice invoice = new Invoice();
				invoice.setType(type.get(3));
				invoice.setMonth(month.get(9));
				invoice.setYear(year.get(29));
				invoice.setMoney(250000);
				invoice.setVat(0);
				invoice.setUser(user);
				invoiceDao.addInvoice(invoice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	// @Test
	public void testDeleteInvoice() {
		try {
			invoiceDao.deleteInvoice(11);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testUpdateInvoice() {
		try {
			Invoice invoice = invoiceDao.getInvoice(12);
			invoice.setMoney(500000);
			invoiceDao.updateInvoice(invoice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
