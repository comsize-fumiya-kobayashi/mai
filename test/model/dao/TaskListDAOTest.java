package model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryUserStatusBean;

class TaskListDAOTest {

	@Test
	void tes_selectALL() {
		
	TaskListDAO dao = new TaskListDAO();
	List<TaskCategoryUserStatusBean> taskList = new ArrayList<TaskCategoryUserStatusBean>();
	
	try {
		taskList =dao.selectAll();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	assertEquals(1,taskList.get(0).getTaskId());
	assertEquals("未着手サンプルタスク",taskList.get(0).getTaskName());
	assertEquals("新商品A:開発プロジェクト",taskList.get(0).getCategoryName());
	assertEquals(Date.valueOf("2023-12-06"),taskList.get(0).getLimitDate());
	assertEquals("山田",taskList.get(0).getUserName());
	assertEquals("未着手",taskList.get(0).getStatusName());
	assertEquals("サンプルメモ",taskList.get(0).getMemo());
	
	assertEquals(2,taskList.get(1).getTaskId());
	assertEquals("着手サンプルタスク",taskList.get(1).getTaskName());
	assertEquals("新商品A:開発プロジェクト",taskList.get(1).getCategoryName());
	assertEquals(Date.valueOf("2023-12-31"),taskList.get(1).getLimitDate());
	assertEquals("山田",taskList.get(1).getUserName());
	assertEquals("着手",taskList.get(1).getStatusName());
	assertEquals("サンプルメモ",taskList.get(1).getMemo());
	
	assertEquals(7,taskList.get(2).getTaskId());
	assertEquals("未着手サンプル",taskList.get(2).getTaskName());
	assertEquals("既存商品B:開発プロジェクト",taskList.get(2).getCategoryName());
	assertEquals(Date.valueOf("2023-12-06"),taskList.get(2).getLimitDate());
	assertEquals("テスト1",taskList.get(2).getUserName());
	assertEquals("完了",taskList.get(2).getStatusName());
	assertEquals("サンプル",taskList.get(2).getMemo());
	
	assertEquals(22,taskList.get(3).getTaskId());
	assertEquals("テストサンプル",taskList.get(3).getTaskName());
	assertEquals("新商品A:開発プロジェクト",taskList.get(3).getCategoryName());
	assertEquals(Date.valueOf("2023-12-08"),taskList.get(3).getLimitDate());
	assertEquals("山田",taskList.get(3).getUserName());
	assertEquals("未着手",taskList.get(3).getStatusName());
	assertEquals("メモ",taskList.get(3).getMemo());
	
	assertEquals(23,taskList.get(4).getTaskId());
	assertEquals("テストサンプル",taskList.get(4).getTaskName());
	assertEquals("新商品A:開発プロジェクト",taskList.get(4).getCategoryName());
	assertEquals(Date.valueOf("2023-12-08"),taskList.get(4).getLimitDate());
	assertEquals("山田",taskList.get(4).getUserName());
	assertEquals("未着手",taskList.get(4).getStatusName());
	assertEquals("メモ",taskList.get(4).getMemo());
	}
}
