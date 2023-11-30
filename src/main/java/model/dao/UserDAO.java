package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ユーザマスタDAOクラス
 * @author 村田
 */
public class UserDAO {

	/**
	 * ユーザが存在する場合はtrue、存在しない場合はfalseを返すメソッド
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return 真偽値
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean isExistUser(String userId, String password) throws ClassNotFoundException, SQLException {
		
		String select = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(select)){
			
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				return true;
			}
			return false;
		}
	}
	
	/**
	 * ユーザ名を返すメソッド
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return ユーザ名(なければnull)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String userName(String userId, String password) throws ClassNotFoundException, SQLException {
		
		String select = "SELECT user_name FROM m_user WHERE user_id = ? AND password = ?";
		
		String userName = null;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(select)){
			
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				userName = res.getString("user_name");
			}
		}
		return userName;
	}
}
