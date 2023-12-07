package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TaskDeleteDAOTest {

	@Test
	void test_deleteTask() {
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		int processingNumber = 0;
		
		try {
			processingNumber = dao.deleteTask(21);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1,processingNumber);
	}

}
