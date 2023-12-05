package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UpdateDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.UpdateBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAddServlet
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int taskId = Integer.parseInt(request.getParameter("task_id"));

		List<CategoryBean> categoryList = null;
		List<StatusBean> statusList = null;
		List<UserBean> userList = null;

		UpdateDAO dao = new UpdateDAO();
		UpdateBean updateTask = new UpdateBean();

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

		// リクエストスコープへの属性の
		session.setAttribute("updateTask", updateTask);
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("statusList", statusList);
		session.setAttribute("userList", userList);

//		request.setAttribute("updateTask", updateTask);
//		request.setAttribute("categoryList", categoryList);
//		request.setAttribute("statusList", statusList);
//		request.setAttribute("userList", userList);
		// 商品登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//	HttpSession session = request.getSession();

		int processingNumber = 0;
		UpdateDAO dao = new UpdateDAO();
		UpdateBean updateTask = new UpdateBean();
		
		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] selectCategory = request.getParameter("select_category").split(",");
		updateTask.setCategoryId(Integer.parseInt(selectCategory[0]));
		updateTask.setCategoryName(selectCategory[1]);
		
		String[] userName = request.getParameter("user_name").split(",");
		
		updateTask.setUserId(userName[0]);
		updateTask.setUserName(userName[1]);
		
		String[] statusName= request.getParameter("status_name").split(",");
		updateTask.setStatusCode(statusName[0]);
		updateTask.setStatusName(statusName[1]);
		
		updateTask.setTaskName(request.getParameter("task_name"));
		

		updateTask.setLimitDate(Date.valueOf(request.getParameter("limit_date")));
	
	//	updateTask.setUserName(request.getParameter("user_name"));
		updateTask.setMemo(request.getParameter("memo"));
	//	updateTask.setStatusName(request.getParameter("status_name"));
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
		// セッション情報を削除
		//	session.removeAttribute("updateTask");
		String url = "";
		if (processingNumber > 0) {
			url = "Update-success.jsp";
		} else {
			url = "UpdateFailure.jsp";

		}
		// 変更結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
