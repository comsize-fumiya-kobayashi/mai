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

public class TaskAddDAO {
	
	public int insertTask(TaskListBean itemInfo)
			throws SQLException, ClassNotFoundException {

		int processingNumber = 0; //処理件数
		String sql = "INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo)VALUES(?,?,?,?,?,?)";
		
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, itemInfo.getTaskName());
			pstmt.setInt(2, itemInfo.getCategoryId());
			pstmt.setInt(3, itemInfo.getLimitDate());
			pstmt.setString(4, itemInfo.getUserId());
			pstmt.setInt(5, itemInfo.getStatusCode());
			pstmt.setString(1, itemInfo.getMemo());
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
				int statusCode = res.getInt("status_code");
				String statusName = res.getString("status_name");
				StatusBean status = new StatusBean();
				status.setStatusCode(statusCode);
				status.setStatusName(statusName);
				statusList.add(status);
			}
		}
		return statusList;
	}


}
