package model.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TaskListBean {
	
	private int taskId;
	private String taskName;
	private int categoryId;
	private String categoryName;
	private Date limitDate;
	private String userId;
	private String userName;
	private String statusCode;
	private String statusName;
	private String memo;
	private Timestamp createDatetime;
	private Timestamp updateDatetime;
	
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
