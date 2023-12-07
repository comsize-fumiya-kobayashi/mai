package model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryUserStatusBean;

class TaskUpdateDAOTest {

	@Test
	void test_updateTask() {
		TaskUpdateDAO dao = new TaskUpdateDAO();
		TaskCategoryUserStatusBean taskCategoryUserStatusBean = new TaskCategoryUserStatusBean();
		taskCategoryUserStatusBean.setTaskId(22);
		taskCategoryUserStatusBean.setTaskName("テストサンプル");
		taskCategoryUserStatusBean.setCategoryId(1);
		taskCategoryUserStatusBean.setLimitDate(Date.valueOf("2023-12-8"));
		taskCategoryUserStatusBean.setUserId("admin");
		taskCategoryUserStatusBean.setStatusCode("00");
		taskCategoryUserStatusBean.setMemo("メモ");
		
		int processingNumber = 0;
		
		try {
			processingNumber = dao.updateTask(taskCategoryUserStatusBean);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
        
        // Check if the data was updated correctly
        assertEquals(1,processingNumber);
	}
		

}
