package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentListDAO;
import model.entity.CommentBean;
import model.entity.TaskCategoryUserStatusBean;

/**
 * Servlet implementation class CommentListServlet
 * @author 鈴木
 */
@WebServlet("/comment-list-servlet")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		List<CommentBean> commentList = null;
		TaskCategoryUserStatusBean taskData = null;
		
		//値の取得(task_id = 1はここまで来ている)
		int taskNum = Integer.parseInt(request.getParameter("task_id"));
		
		// DAOの生成
		CommentListDAO dao = new CommentListDAO();
		

		try {
			// コメントテーブルからコメントの一覧情報を取得
			commentList = dao.commentAll(taskNum);
			//タスクテーブルから1つのタスク情報を取得
			taskData = dao.selectTask(taskNum);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("commentList", commentList);
		request.setAttribute("taskData",taskData);

		// 商品一覧画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("comment-list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
