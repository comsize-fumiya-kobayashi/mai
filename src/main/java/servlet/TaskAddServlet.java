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

import model.dao.TaskAddDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskListBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/task-add-servlet")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CategoryBean> categoryList = null;
		List<StatusBean> statusList = null;
		List<UserBean> userList = null;

		TaskAddDAO dao = new TaskAddDAO();
		try {
			// プルダウン用のカテゴリ一覧を取得
			categoryList = dao.selectCategory();
			statusList = dao.selectStatus();
			userList = dao.selectUser();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// リクエストスコープへの属性の設定
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("statusList", statusList);
		session.setAttribute("userList", userList);

		// 商品登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// DAOのインスタンス化
		TaskAddDAO dao = new TaskAddDAO();
		// Beanのインスタンス化
		TaskListBean taskList = new TaskListBean();

		// 入力された情報をbeanにセット
		
		taskList.setTaskName(request.getParameter("task_name"));
		taskList.setCategoryId(Integer.parseInt(request.getParameter("category_id")));
		if(!request.getParameter("date").isEmpty()) {
			taskList.setLimitDate(Date.valueOf(request.getParameter("date")));
		}
		taskList.setUserId(request.getParameter("user_id"));
		taskList.setStatusCode(request.getParameter("status_code"));
		taskList.setMemo(request.getParameter("memo"));
		
		int processingNumber = 0;// 処理件数

		try {
			processingNumber = dao.insertTask(taskList);// 登録処理
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "";// 転送先
		// 遷移先画面の分岐
		if (processingNumber > 0) {
			url = "register-success.jsp";// 登録成功画面
		} else {
			url = "register-failure.jsp";// 登録失敗画面
		}
		// 画面遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
