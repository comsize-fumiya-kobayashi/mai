package model.entity;

public class UserBean {

	/** ユーザID */
	private String userId;
	
	/** パスワード */
	private String password;
	
	/** ユーザ名 */
	private String userName;

	/** デフォルトコンストラクター */
	public UserBean() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
