package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentAddDAO;
import model.entity.CommentBean;
import model.entity.TaskCategoryUserStatusBean;

/**
 * Servlet implementation class CommentContributionServlet
 * @author 鈴木
 */
@WebServlet("/comment-contribution-servlet")
public class CommentContributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentContributionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskCategoryUserStatusBean taskInfo = new TaskCategoryUserStatusBean();
		CommentBean bean = new CommentBean();
		int taskId = Integer.parseInt(request.getParameter("task_id"));

		// 現在日付取得
		LocalDate localDate = LocalDate.now();

		CommentAddDAO dao = new CommentAddDAO();
		try {
			// プルダウン用のカテゴリ一覧を取得
			taskInfo = dao.taskSearch(taskId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// セッションスコープへの属性の設定
		session.setAttribute("taskInfo", taskInfo);

		// 商品登録画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("comment-contribution.jsp");
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
		CommentAddDAO dao = new CommentAddDAO();
		// Beanのインスタンス化
		CommentBean CommentValue = new CommentBean();
		

		// 入力された情報をbeanにセット

		CommentValue.setTaskId(Integer.parseInt(request.getParameter("task_id")));
		CommentValue.setUserId(request.getParameter("user_id"));
		CommentValue.setComment(request.getParameter("comment"));

		int processingNumber = 0;// 処理件数

		try {
			processingNumber = dao.addComment(CommentValue);// 登録処理
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "";// 転送先
		// 遷移先画面の分岐
		if (processingNumber > 0) {
			url = "contribution-success.jsp";// 登録成功画面
		} else {
			url = "contribution-failure.jsp";// 登録失敗画面
		}
		// 画面遷移
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
