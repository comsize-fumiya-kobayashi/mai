package model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserDAOTest {
	@Test
	void test_isExistUser1() {
		UserDAO dao = new UserDAO();
		
		boolean b = false;
		
		try {
			b = dao.isExistUser("admin", "admin");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertTrue(b);
	}
	@Test
	void test_isExistUser2() {
		UserDAO dao = new UserDAO ();
		
		boolean b = false;
		
		try {
			b = dao.isExistUser("", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertFalse(b);
	}
	@Disabled
	@Test
	void test_userName1() {
		UserDAO dao = new UserDAO ();
		String userName = null;
		
		try {
			//userName = dao.userName("山田", userName);
			userName = dao.userName("admin","admin");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("山田", userName);
		}
	@Disabled 
	@Test
	void test_userName2() {
		UserDAO dao = new UserDAO ();
		String userName = null;
		
		try {
			userName = dao.userName(" ", " ");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertNull(userName);
	}
	}
