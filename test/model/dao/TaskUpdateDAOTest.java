package model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.entity.CategoryBean;
import model.entity.StatusBean;
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
	@Disabled
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
	@Disabled
	@Test
	void test_selectCategory() {
		TaskUpdateDAO dao = new TaskUpdateDAO();
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		try {
			categoryList = dao.selectCategory();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1,categoryList.get(0).getCategoryId());
		assertEquals("新商品A:開発プロジェクト",categoryList.get(0).getCategoryName());
		assertEquals(2,categoryList.get(1).getCategoryId());
		assertEquals("既存商品B:開発プロジェクト",categoryList.get(1).getCategoryName());
	}
	
	@Test
	void test_selectStatus() {
		TaskUpdateDAO dao = new TaskUpdateDAO();
		List<StatusBean> statusList = new ArrayList<StatusBean>();
		
		try {
			statusList = dao.selectStatus();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("00",statusList.get(0).getStatusCode());
		assertEquals("未着手",statusList.get(0).getStatusName());
		assertNull(statusList.get(0).getUpdateDatetme());
		assertEquals("50",statusList.get(1).getStatusCode());
		assertEquals("着手",statusList.get(1).getStatusName());
		assertNull(statusList.get(1).getUpdateDatetme());
		assertEquals("99",statusList.get(2).getStatusCode());
		assertEquals("完了",statusList.get(2).getStatusName());
		assertNull(statusList.get(2).getUpdateDatetme());
	}
}