package model.entity;

import java.sql.Timestamp;

/**
 * ステータスBeanクラス
 * @author アルチャナ
 */
public class StatusBean {
	
	/** ステータスコード */
	private String statusCode;
	
	/** ステータス名 */
	private String statusName;
	
	/** 更新日時 */
	private Timestamp updateDatetme;
	
	/** デフォルトコンストラクター */
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
