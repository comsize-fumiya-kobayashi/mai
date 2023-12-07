package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskUpdateDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskCategoryUserStatusBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAddServlet
 * @author アルチャナ
 */
@WebServlet("/task-update-servlet")
public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskUpdateServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int taskId = Integer.parseInt(request.getParameter("task_id"));

		List<CategoryBean> categoryList = null;
		List<StatusBean> statusList = null;
		List<UserBean> userList = null;

		TaskUpdateDAO dao = new TaskUpdateDAO();
		TaskCategoryUserStatusBean updateTask = new TaskCategoryUserStatusBean();
		LocalDate currentDate = LocalDate.now();
		try {
			// プルダウン用のカテゴリ一覧を取得
			updateTask = dao.selectTask(taskId);
			categoryList = dao.selectCategory();
			statusList = dao.selectStatus();
			userList = dao.selectUser();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// セッションスコープへの属性の設定
		session.setAttribute("updateTask", updateTask);
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("statusList", statusList);
		session.setAttribute("userList", userList);
		// リクエストスコープへの属性の設定
		request.setAttribute("currentDate", currentDate);

		// 商品登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("task-update.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int processingNumber = 0;
		TaskUpdateDAO dao = new TaskUpdateDAO();
		TaskCategoryUserStatusBean updateTask = new TaskCategoryUserStatusBean();
		
		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] selectCategory = request.getParameter("select_category").split(",");
		String[] userName = request.getParameter("user_name").split(",");
		String[] statusName= request.getParameter("status_name").split(",");
		
		// 編集する情報をセット
		updateTask.setCategoryId(Integer.parseInt(selectCategory[0]));
		updateTask.setCategoryName(selectCategory[1]);
		updateTask.setUserId(userName[0]);
		updateTask.setUserName(userName[1]);
		updateTask.setStatusCode(statusName[0]);
		updateTask.setStatusName(statusName[1]);
		updateTask.setTaskName(request.getParameter("task_name"));
		if(!request.getParameter("limit_date").isEmpty()) {
			updateTask.setLimitDate(Date.valueOf(request.getParameter("limit_date")));
		}
		updateTask.setMemo(request.getParameter("memo"));
		updateTask.setTaskId(Integer.parseInt(request.getParameter("task_id")));

		try {
			processingNumber = dao.updateTask(updateTask);//変更処理
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 変更情報をリクエストスコープに設定
		request.setAttribute("updateTask", updateTask);
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
	
		String url = "";
		if (processingNumber > 0) {
			url = "update-success.jsp";
		} else {
			url = "update-failure.jsp";
		}
		// 変更結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
