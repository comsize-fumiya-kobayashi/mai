package model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryUserStatusBean;

class TaskUpdateDAOTest {
	@Disabled
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
		assertEquals(1, processingNumber);
	}
	
	@Test
	void test_selectTask() {
		TaskUpdateDAO dao = new TaskUpdateDAO();

		TaskCategoryUserStatusBean tname = null;
		try {
			tname = dao.selectTask(22);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals(22, tname.getTaskId());
		assertEquals("テストサンプル",tname.getTaskName());
		assertEquals(1, tname.getCategoryId());
		assertEquals("新商品A:開発プロジェクト",tname.getCategoryName());
		assertEquals(Date.valueOf("2023-12-08"),tname.getLimitDate());
		assertEquals("admin", tname.getUserId());
		assertEquals("山田",tname.getUserName());
		assertEquals("00",tname.getStatusCode());
		assertEquals("未着手",tname.getStatusName());
		assertEquals("メモ",tname.getMemo());
	}
	
}
