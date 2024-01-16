package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.CommentBean;
import model.entity.TaskCategoryUserStatusBean;

/**
 * コメントを追加するDAOクラス
 * @author 鈴木
 */
public class CommentAddDAO {
	
	/**
	 * コメントをするタスクの情報を検索するメソッド
	 * @param taskId タスクID
	 * @return タスク情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskCategoryUserStatusBean taskSearch(int taskId) throws SQLException, ClassNotFoundException {
		TaskCategoryUserStatusBean taskValue = new TaskCategoryUserStatusBean();
		
		String sql = "SELECT t1.task_id, t1.task_name,t1.category_id,t1.user_id,t1.status_code, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo "
				+ "FROM t_task t1 "
				+ "LEFT JOIN m_category t2 ON t1.category_id = t2.category_id "
				+ "LEFT JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ "LEFT JOIN m_status t4 ON t1.status_code = t4.status_code WHERE t1.task_id = ?";

		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1,taskId);
				ResultSet res = pstmt.executeQuery();
			
			
			
			while (res.next()) {
				taskValue.setTaskId(res.getInt("t1.task_id"));
				taskValue.setTaskName(res.getString("t1.task_name"));
				taskValue.setCategoryId(res.getInt("t1.category_id"));
				taskValue.setCategoryName(res.getString("t2.category_name"));
				taskValue.setLimitDate(res.getDate("t1.limit_date"));
				taskValue.setUserId(res.getString("t1.user_id"));
				taskValue.setUserName(res.getString("t3.user_name"));
				taskValue.setStatusCode(res.getString("t1.status_code"));
				taskValue.setStatusName(res.getString("t4.status_name"));
				taskValue.setMemo(res.getString("t1.memo"));

			}

			
		}

		
		return taskValue;
	}
	
	/**
	 * コメントを追加するメソッド
	 * @param commentValue コメント情報
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int addComment (CommentBean commentValue) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "INSERT INTO t_comment(task_id,user_id,comment)VALUES(?,?,?)";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, commentValue.getTaskId());
			pstmt.setString(2, commentValue.getUserId());
			pstmt.setString(3, commentValue.getComment());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
