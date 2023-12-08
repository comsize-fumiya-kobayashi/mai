package model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryUserStatusBean;

class TaskDeleteDAOTest {
	@Disabled
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
	
	@Test
	void test_selectTask() {
		TaskDeleteDAO dao = new TaskDeleteDAO();
		TaskCategoryUserStatusBean tName = null;
		try {
			tName = dao.selectTask(22);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		assertEquals(22,tName.getTaskId());
		assertEquals("テストサンプル",tName.getTaskName());
		assertEquals(1, tName.getCategoryId());
		assertEquals("新商品A:開発プロジェクト",tName.getCategoryName());
		assertEquals(Date.valueOf("2023-12-08"),tName.getLimitDate());
		assertEquals("admin", tName.getUserId());
		assertEquals("山田",tName.getUserName());
		assertEquals("00",tName.getStatusCode());
		assertEquals("未着手",tName.getStatusName());
		assertEquals("メモ",tName.getMemo());
	}
}
