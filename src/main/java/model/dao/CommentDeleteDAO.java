package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.CommentBean;

/**
 * コメントを削除するDAOクラス
 * @author 鈴木
 */
public class CommentDeleteDAO {
	
	/**
	 * 削除するコメントを検索するメソッド
	 * @param commentId コメントID
	 * @return コメント情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CommentBean selectComment(int commentId) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT t1.task_id, t1.task_name, t2.user_id, t2.comment_id, t2.comment, t2.update_datetime "
				+"FROM t_task t1 INNER JOIN t_comment t2 "
				+"ON t1.task_id = t2.task_id "
				+"WHERE t2.comment_id = ?";

		CommentBean commentValue = new CommentBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1,commentId);
				ResultSet res = pstmt.executeQuery();

			
			while(res.next()){
				int taskId = res.getInt("t1.task_id");
				String taskName = res.getString("t1.task_name");
				String userId = res.getString("t2.user_id");
				int commentNum = res.getInt("t2.comment_id");
				String comment = res.getString("t2.comment");
				Date updateDateTime = res.getDate("t2.update_datetime");
				
				commentValue.setTaskId(taskId);
				commentValue.setTaskName(taskName);
				commentValue.setUserId(userId);
				commentValue.setCommentId(commentNum);
				commentValue.setComment(comment);
				commentValue.setUpdateTime(updateDateTime.toLocalDate());
				}
		}
		return commentValue;
	}
	
	/**
	 * コメントを削除するメソッド
	 * @param commentId コメントID
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteComment (int commentId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_comment WHERE comment_id = ?";
		
		int processingNumber = 0; //処理件数
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, commentId);
			processingNumber = pstmt.executeUpdate();
			
		}
		return processingNumber;
	}
}
