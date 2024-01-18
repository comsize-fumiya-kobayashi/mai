package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Util;
import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 * @author 村田
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストエンコーディング指定
		request.setCharacterEncoding("UTF-8");
		
		// 入力フォームのパラメータ値を代入
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		//ハッシュ化
		Util util = new Util();
		
		password = util.getSafetyPassword(password, password);
		
		// セッション
		HttpSession session = request.getSession();
		
		// 変数初期化
		boolean isExistUser = false;
		String userName = null;
		String url = null;
		
		// インスタンス化
		UserDAO dao = new UserDAO();
		
		try {
			// ログインユーザの有無
			isExistUser = dao.isExistUser(userId, password);
			// ログインユーザの名前
			userName = dao.userName(userId, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		// ログインユーザの有無判定
		if (isExistUser) {
			url = "menu.jsp";
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
		} else {
			url = "login.jsp";
			request.setAttribute("message", "ログイン認証失敗");
		}
		
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
