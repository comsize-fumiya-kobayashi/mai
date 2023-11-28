package model.entity;

import java.sql.Timestamp;

public class StatusBean {
	
	private int statusCode;
	private String statusName;
	private Timestamp updateDatetme;
	
	public StatusBean() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Timestamp getUpdateDatetme() {
		return updateDatetme;
	}

	public void setUpdateDatetme(Timestamp updateDatetme) {
		this.updateDatetme = updateDatetme;
	}
	
}
