package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.UpdateBean;


public class UpdateDAO {

	public int updateTask(UpdateBean updateResult) throws SQLException, ClassNotFoundException {
		
		int processingNumber = 0; //処理件数
		
	String sql = "UPDATE m_task JOIN m_user ON update_datetime JOIN mcategory ON category_id= category_id JOIN m_status "
			+ "ON status_code= status_code SET task_name=?,category_name=?,limit_date=?, user_name=?,memo=?,status_name=?"
			+ " WHERE task_name=?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, updateResult.getTaskName());
			pstmt.setString(2, updateResult.getCategoryName());
			pstmt.setInt(3, updateResult.getLimitDate());
			pstmt.setString(4, updateResult.getUserName());
			pstmt.setString(5, updateResult.getMemo());
			pstmt.setString(6,updateResult.getStatusName());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

}
