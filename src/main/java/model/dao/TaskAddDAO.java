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
import model.entity.TaskListBean;
import model.entity.UserBean;

public class TaskAddDAO {
	
	public int insertTask(TaskListBean taskInfo)
			throws SQLException, ClassNotFoundException {

		int processingNumber = 0; //処理件数
		
		String sql = "INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo)VALUES(?,?,?,?,?,?)";
		
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, taskInfo.getTaskName());
			pstmt.setInt(2, taskInfo.getCategoryId());
			pstmt.setDate(3, taskInfo.getLimitDate());
			pstmt.setString(4, taskInfo.getUserId());
			pstmt.setString(5, taskInfo.getStatusCode());
			pstmt.setString(6, taskInfo.getMemo());
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
