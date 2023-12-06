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

import model.dao.TaskDeleteDAO;
import model.entity.TaskCategoryUserStatusBean;
/**
 * Servlet implementation class ItemDeleteServlet
 * @author アルチャナ
 */
@WebServlet(name = "task-delete-servlet", urlPatterns = { "/task-delete-servlet" })
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteServlet() {
        super();
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		

		TaskDeleteDAO dao = new TaskDeleteDAO();
		TaskCategoryUserStatusBean deleteTask = new TaskCategoryUserStatusBean();

		try {
			// プルダウン用のカテゴリ一覧を取得
			deleteTask = dao.selectTask(taskId);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		// リクエストスコープへの属性の
		session.setAttribute("deleteTask", deleteTask);

		RequestDispatcher rd = request.getRequestDispatcher("delete-confirm.jsp");
		rd.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("UTF-8");
				
				int taskId = Integer.parseInt(request.getParameter("task_id"));
				TaskDeleteDAO dao = new TaskDeleteDAO();
				int processingNumber = 0; //処理件数
				try {
					// 削除処理
					processingNumber = dao.deleteTask(taskId);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("processingNumber", processingNumber);
				// 削除結果画面に遷移
				RequestDispatcher rd = request.getRequestDispatcher("delete-result.jsp");
				rd.forward(request, response);
					
	}

}
