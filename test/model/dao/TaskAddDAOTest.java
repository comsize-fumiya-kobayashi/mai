package model.dao;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskCategoryUserStatusBean;
import model.entity.UserBean;

class TaskAddDAOTest {

	@Disabled
	@Test
	void test_insertTask() {
		TaskAddDAO dao = new TaskAddDAO();
		TaskCategoryUserStatusBean taskCategoryUserStatusBean = new TaskCategoryUserStatusBean();

		taskCategoryUserStatusBean.setTaskName("テストサンプル");
		taskCategoryUserStatusBean.setCategoryId(1);
		taskCategoryUserStatusBean.setLimitDate(Date.valueOf("2023-12-8"));
		taskCategoryUserStatusBean.setUserId("admin");
		taskCategoryUserStatusBean.setStatusCode("00");
		taskCategoryUserStatusBean.setMemo("メモ");

		int processingNumber = 0;

		try {
			processingNumber = dao.insertTask(taskCategoryUserStatusBean);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Check if the data was updated correctly
		assertEquals(1, processingNumber);
	}

	@Test
	void test_selectCategory() {

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		//読み込み行
		String line;

		//読み込み行数の管理
		int i = 0;

		//列名を管理する為の配列
		// String[] arr = null;

		// テーブル行数管理
		int listSize = 0;

		try {
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("m_category.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i == 0) {

					//カンマで分割した内容を配列に格納する
					// arr = { "no","name","age","gender","bloodtype" };
					// arr = line.split(","); 

				} else {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");

					// テーブルのデータを格納するリスト
					List<CategoryBean> categoryList = null;

					// インスタンス化
					TaskAddDAO dao = new TaskAddDAO();

					// テーブルデータ全件取得
					categoryList = dao.selectCategory();

					// 比較
					assertEquals(Integer.parseInt(data[0]), categoryList.get(listSize).getCategoryId());
					assertEquals(data[1].replace("\"", ""),
							categoryList.get(listSize).getCategoryName());
					listSize++;
				}
				//行数のインクリメント
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	void test_selectStatus() {

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		//読み込み行
		String line;

		//読み込み行数の管理
		int i = 0;

		//列名を管理する為の配列
		// String[] arr = null;

		// テーブル行数管理
		int listSize = 0;

		try {
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("m_status.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i == 0) {

					//カンマで分割した内容を配列に格納する
					// arr = { "no","name","age","gender","bloodtype" };
					// arr = line.split(","); 

				} else {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");

					// テーブルのデータを格納するリスト
					List<StatusBean> statusList = null;

					// インスタンス化
					TaskAddDAO dao = new TaskAddDAO();

					// テーブルデータ全件取得
					statusList = dao.selectStatus();

					// 比較
					assertEquals(data[0].replace("\"", ""), statusList.get(listSize).getStatusCode());
					assertEquals(data[1].replace("\"", ""), statusList.get(listSize).getStatusName());
					listSize++;
				}
				//行数のインクリメント
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	void test_selectUser() {

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		//読み込み行
		String line;

		//読み込み行数の管理
		int i = 0;

		//列名を管理する為の配列
		// String[] arr = null;

		// テーブル行数管理
		int listSize = 0;

		try {
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("m_user.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i == 0) {

					//カンマで分割した内容を配列に格納する
					// arr = { "no","name","age","gender","bloodtype" };
					// arr = line.split(","); 

				} else {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");

					// テーブルのデータを格納するリスト
					List<UserBean> userList = null;

					// インスタンス化
					TaskAddDAO dao = new TaskAddDAO();

					// テーブルデータ全件取得
					userList = dao.selectUser();

					// 比較
					assertEquals(data[0].replace("\"", ""), userList.get(listSize).getUserId());
					assertEquals(data[2].replace("\"", ""), userList.get(listSize).getUserName());
					listSize++;
				}
				//行数のインクリメント
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
