package model.entity;

import java.sql.Timestamp;

public class StatusBean {
	
	private String statusCode;
	private String statusName;
	private Timestamp updateDatetme;
	
	public StatusBean() {
		super();
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

	public Timestamp getUpdateDatetme() {
		return updateDatetme;
	}

	public void setUpdateDatetme(Timestamp updateDatetme) {
		this.updateDatetme = updateDatetme;
	}
	
}
