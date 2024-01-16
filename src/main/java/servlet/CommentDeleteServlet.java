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

import model.dao.CommentDeleteDAO;
import model.entity.CommentBean;

/**
 * Servlet implementation class CommentDeleteServlet
 * @author 鈴木
 */
@WebServlet("/comment-delete-servlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int commentId = Integer.parseInt(request.getParameter("comment_id"));
		

		CommentDeleteDAO dao = new CommentDeleteDAO();
		CommentBean selectComment = new CommentBean();

		try {
			// プルダウン用のカテゴリ一覧を取得
			selectComment = dao.selectComment(commentId);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// リクエストスコープへの属性の
		session.setAttribute("selectComment", selectComment);

		RequestDispatcher rd = request.getRequestDispatcher("comment-delete-confirm.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int commentId = Integer.parseInt(request.getParameter("comment_id"));
		CommentDeleteDAO dao = new CommentDeleteDAO();
		int processingNumber = 0; //処理件数
		try {
			// 削除処理
			processingNumber = dao.deleteComment(commentId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("processingNumber", processingNumber);
		// 削除結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("comment-delete-result.jsp");
		rd.forward(request, response);
	}

}
