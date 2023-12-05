package model.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * タスクBeanクラス
 * @author 入江
 */
// TODO Beanの名前変更(タスクカテゴリユーザステータスBeanクラス：TaskCategoryUserStatusBean)
// TODO UpdateDeleteもこのBeanを使用する
public class TaskListBean {
	
	/** タスクID */
	private int taskId;
	
	/** タスク名 */
	private String taskName;
	
	/** カテゴリID */
	private int categoryId;
	
	/** カテゴリ名 */
	private String categoryName;
	
	/** 期限 */
	private Date limitDate;
	
	/** ユーザID */
	private String userId;
	
	/** ユーザ名 */
	private String userName;
	
	/** ステータスコード */
	private String statusCode;
	
	/** ステータス名 */
	private String statusName;
	
	/** メモ */
	private String memo;
	
	/** 登録日時 */
	private Timestamp createDatetime;
	
	/** 更新日時 */
	private Timestamp updateDatetime;
	
	/** デフォルトコンストラクター */
	public TaskListBean() {
		super();
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
