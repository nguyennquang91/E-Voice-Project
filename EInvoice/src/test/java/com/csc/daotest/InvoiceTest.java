package com.csc.daotest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.dao.InvoiceDAO;
import com.csc.dao.TypeDAO;
import com.csc.dao.UserDAO;
import com.csc.model.Invoice;
import com.csc.model.Type;
import com.csc.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class InvoiceTest {

	@Autowired
	UserDAO userDao;

	@Autowired
	InvoiceDAO invoiceDao;

	@Autowired
	TypeDAO typeDao;

	@Test
	public void testGetInvoice() {
		try {
			Invoice invoice = invoiceDao.getInvoice(2);
			Assert.assertNotNull(invoice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testAddType() {
		try {
			String[] typeList = { "Electric", "Water", "Telephone", "Internet" };
			User user = userDao.getUser(13);
			if (user != null) {
				for (String t : typeList) {
					Type type = new Type();
					type.setName(t);
					type.setUser(user);
					typeDao.addType(type);
				}
			} else
				System.out
						.println("KHONG ADD DUOC INVOICE_TYPE VI USER KHONG CO TON TAI !!!");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	//@Test
	public void testDeleteType() {
		try {
			typeDao.deleteType(32);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
