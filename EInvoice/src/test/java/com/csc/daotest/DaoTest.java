package com.csc.daotest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.dao.UserDAO;
import com.csc.dao.UserRoleDAO;
import com.csc.model.User;
import com.csc.model.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class DaoTest {

	@Autowired
	UserDAO userDao;

	@Autowired
	UserRoleDAO userRoleDao;

	@BeforeClass
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}

	@Test
	public void testGetUser() {
		try {
			User user = userDao.getUser(1);
			Assert.assertNotNull(user);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testGetUserByName() {
		try {
			User user = userDao.getUserByName("trieuliem");
			Assert.assertNotNull(user);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	//@Test
	public void testAddUser() {
		try {
			UserRole role = new UserRole();
			User user = new User();
			role.setUsername("trieuliem");
			role.setRole("ROLE_USER");
			user.setUsername("trieuliem");
			user.setEmail("trieuliem18@gmail.com");
			user.setEnabled(1);
			user.setPassword("khongbiet");
			user.setExpenseLimit(0);
			user.setRole(role);
			userRoleDao.addUserRole(role);
			userDao.addUser(user);
			if (userDao.getUserByName("trieuliem") != null)
				System.out.println("SUCCESS");
			else
				System.out.println("FAIL");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testDeleteUser() {
		try {
			userDao.deleteUser(16);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testUpdateUser() {
		try {
			User user = userDao.getUser(11);
			user.setPassword("liem123");
			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	// @Test
	public void testGetAllUser() {
		try {
			ArrayList<User> userList = userDao.getAll();
			Assert.assertNotNull(userList);
			Assert.assertNotEquals(0, userList.size());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
