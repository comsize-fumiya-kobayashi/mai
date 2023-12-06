package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.UpdateBean;
import model.entity.UserBean;

public class DeleteDAO {
	public UpdateBean selectTask(int taskId)
			throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.task_id, t1.task_name,t1.category_id,t1.user_id,t1.status_code, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo "
				+ "FROM t_task t1 "
				+ "LEFT JOIN m_category t2 ON t1.category_id = t2.category_id "
				+ "LEFT JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ "LEFT JOIN m_status t4 ON t1.status_code = t4.status_code WHERE t1.task_id =?;";

		UpdateBean tName = new UpdateBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1,taskId);
				ResultSet res = pstmt.executeQuery();

			// 結果の操作
			while (res.next()) {
				tName.setTaskId(res.getInt("task_id"));
				tName.setTaskName(res.getString("task_name"));
				tName.setCategoryId(res.getInt("category_id"));
				tName.setCategoryName(res.getString("category_name"));
				tName.setLimitDate(res.getDate("limit_date"));
				tName.setUserId(res.getString("user_id"));
				tName.setUserName(res.getString("user_name"));
				tName.setStatusCode(res.getString("status_code"));
				tName.setStatusName(res.getString("status_name"));
				tName.setMemo(res.getString("memo"));

			}
		}
		return tName;

	}
	
	public int deleteTask(int  taskId) throws SQLException, ClassNotFoundException {

		
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		
		int processingNumber = 0; //処理件数
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);
			processingNumber = pstmt.executeUpdate();
			
		}
		return processingNumber;
	}
	public List<CategoryBean> selectCategory() throws SQLException, ClassNotFoundException {

		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_category")) {
			// 結果の操作
			while (res.next()) {
				int categoryId = res.getInt("category_id");
				String categoryName = res.getString("category_name");
				
				CategoryBean category = new CategoryBean();
				
				category.setCategoryId(categoryId);
				category.setCategoryName(categoryName);
				categoryList.add(category);
			}
		}
		return categoryList;
	}

	public List<StatusBean> selectStatus() throws SQLException, ClassNotFoundException {

		List<StatusBean> statusList = new ArrayList<StatusBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_status")) {
			// 結果の操作
			while (res.next()) {
				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");
				
				StatusBean status = new StatusBean();
				
				status.setStatusCode(statusCode);
				status.setStatusName(statusName);
				statusList.add(status);
			}
		}
		return statusList;
	}

	public List<UserBean> selectUser() throws SQLException, ClassNotFoundException {

		List<UserBean> userList = new ArrayList<UserBean>();
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_user")) {
			// 結果の操作
			while (res.next()) {
				String userId = res.getString("user_id");
				String userName = res.getString("user_name");
				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setUserName(userName);
				userList.add(user);
			}
		}
		return userList;
	}
}
