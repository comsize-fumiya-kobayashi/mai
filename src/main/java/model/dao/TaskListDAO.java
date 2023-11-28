package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskListBean;


public class TaskListDAO {
	
	public List<TaskListBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskListBean> taskList = new ArrayList<TaskListBean>();
		String sql = "SELECT t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo "
				+ "FROM t_task t1 "
				+ "LEFT JOIN m_category t2 ON t1.category_id = t2.category_id "
				+ "LEFT JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ "LEFT JOIN m_status t4 ON t1.status_code = t4.status_code ";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			// 結果の操作
			while (res.next()) {
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				Date limitDate = res.getDate("limit_date");
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");
				
				TaskListBean task = new TaskListBean();
				task.setTaskName(taskName);
				task.setCategoryName(categoryName);
				task.setLimitDate(limitDate);
				task.setUserName(userName);
				task.setStatusName(statusName);
				task.setMemo(memo);
				
				taskList.add(task);
				
			}
		}
		return taskList;
	}
}