package model.entity;

import java.sql.Date;

/**
 * コメントBeanクラス
 * @author 鈴木
 */
public class CommentBean {
	
	/** コメント */
	private String comment;
	
	/** タスクID */
	private int taskId;
	
	/** タスク名 */
	private String taskName;
	
	/** ユーザID */
	private String userId;
	
	/** コメントID */
	private int commentId;
	
	/** 投稿日 */
	private Date updateTime;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getCommentId() {
		return commentId;
	}
	
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

}
