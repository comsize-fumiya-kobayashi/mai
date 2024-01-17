package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.CommentBean;
import model.entity.TaskCategoryUserStatusBean;

/**
 * コメントを一覧表示するDAOクラス
 * @author 鈴木
 */
public class CommentListDAO {
	
	/**
	 * 1つのタスクの全てのコメントを検索するメソッド
	 * @param taskNum タスクID
	 * @return 1つのタスクの全てのコメント情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CommentBean> commentAll(int taskNum) throws SQLException, ClassNotFoundException {
		
		List<CommentBean> commentList = new ArrayList<CommentBean>();
		
		//同じカラムが2つのテーブルにある場合、参考にするテーブルを反映しなければテーブルが正しく機能しないため、注意する
		String sql = "SELECT t1.task_id, t1.task_name, t2.user_id, t2.comment_id, t2.comment, t2.update_datetime "
				+"FROM t_task t1 INNER JOIN t_comment t2 "
				+"ON t1.task_id = t2.task_id "
				+"WHERE t2.task_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1,taskNum);
				ResultSet res = pstmt.executeQuery();

			
			while(res.next()){
				int taskId = res.getInt("t1.task_id");
				String taskName = res.getString("t1.task_name");
				String userId = res.getString("t2.user_id");
				int commentId = res.getInt("t2.comment_id");
				String comment = res.getString("t2.comment");
				LocalDate updateDate = res.getDate("t2.update_datetime").toLocalDate();
				CommentBean commentValue = new CommentBean();
				
				commentValue.setTaskId(taskId);
				commentValue.setTaskName(taskName);
				commentValue.setUserId(userId);
				commentValue.setCommentId(commentId);
				commentValue.setComment(comment);
				
				
				commentValue.setUpdateTime(updateDate);
				
				commentList.add(commentValue);
				
			}
		}

		
		return commentList;
	}
	
	/**
	 * タスクの検索するメソッド
	 * @param taskNum taskID
	 * @return タスク情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskCategoryUserStatusBean selectTask(int taskNum) throws SQLException, ClassNotFoundException {
		
		TaskCategoryUserStatusBean taskValue = new TaskCategoryUserStatusBean();
		
		String sql = "SELECT t1.task_id, t1.task_name,t1.category_id,t1.user_id,t1.status_code, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo "
				+ "FROM t_task t1 "
				+ "LEFT JOIN m_category t2 ON t1.category_id = t2.category_id "
				+ "LEFT JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ "LEFT JOIN m_status t4 ON t1.status_code = t4.status_code WHERE t1.task_id = ?";

		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1,taskNum);
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
}
