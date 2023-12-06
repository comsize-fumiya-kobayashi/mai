package model.entity;

import java.sql.Timestamp;

/**
 * カテゴリBeanクラス
 * @author 入江
 */
public class CategoryBean {
	
	/** カテゴリID */
	private int categoryId;
	
	/** カテゴリ名 */
	private String categoryName;
	
	/** 更新日時 */
	private Timestamp updateDatetime;
	
	/** デフォルトコンストラクター */
	public CategoryBean() {
		super();
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

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
