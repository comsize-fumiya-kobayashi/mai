package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskCategoryUserStatusBean;

/**
 * タスク削除DAOクラス
 * @author アルチャナ
 */
public class DeleteDAO {

	/**
	 * 登録画面から削除する情報を削除画面に表示するメソッド
	 * @param taskId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskCategoryUserStatusBean selectTask(int taskId)
			throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.task_id, t1.task_name,t1.category_id,t1.user_id,t1.status_code, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo "
				+ "FROM t_task t1 "
				+ "LEFT JOIN m_category t2 ON t1.category_id = t2.category_id "
				+ "LEFT JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ "LEFT JOIN m_status t4 ON t1.status_code = t4.status_code WHERE t1.task_id =?;";

		TaskCategoryUserStatusBean tName = new TaskCategoryUserStatusBean();
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
	
	/**
	 * 選択したタスクを削除するメソッド
	 * @param taskId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
}
