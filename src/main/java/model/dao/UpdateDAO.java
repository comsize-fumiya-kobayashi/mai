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

public class UpdateDAO {
	public UpdateBean selectTask()
			throws SQLException, ClassNotFoundException {

		String sql = "SELECT task_name FROM t_task Where task_id = ?";

		UpdateBean tName = new UpdateBean();
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			// 結果の操作
			while (res.next()) {

				String taskName = res.getString("task_name");

				tName.setTaskName(taskName);

			}
		}
		return tName;

	}

	public int updateTask(UpdateBean updateResult) throws SQLException, ClassNotFoundException {

		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_task t1 LEFT OUTER JOIN m_user t2 ON t1.user_id = t2.user_id  LEFT OUTER JOIN m_category t3 ON t1.category_id= t3.category_id  LEFT OUTER JOIN m_status t4"
				+ "ON t1.status_code= t4.status_code SET task_name=?,category_name=?,limit_date=?, user_name=?,memo=?,status_name=?"
				+ " WHERE task_name=?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, updateResult.getTaskName());
			pstmt.setString(2, updateResult.getCategoryName());
			pstmt.setDate(3, updateResult.getLimitDate());
			pstmt.setString(4, updateResult.getUserName());
			pstmt.setString(5, updateResult.getMemo());
			pstmt.setString(6, updateResult.getStatusName());
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
