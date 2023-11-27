package model.entity;

public class TaskListBean {
	
	private int tase_id;
	private String task_name;
	private int category_id;
	private String category_name;
	private int limit_date;
	private int user_id;
	private String user_name;
	private int status_code;
	private String status_name;
	private String memo;
	
	public TaskListBean() {
		super();
	}

	public int getTase_id() {
		return tase_id;
	}

	public void setTase_id(int tase_id) {
		this.tase_id = tase_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(int limit_date) {
		this.limit_date = limit_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
