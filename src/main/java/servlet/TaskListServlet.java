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

import model.dao.TaskListDAO;
import model.entity.TaskCategoryUserStatusBean;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/task-list-servlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			List<TaskCategoryUserStatusBean> taskList = null;
			// DAOの生成
			TaskListDAO dao = new TaskListDAO();

			try {
				// 商品マスタから商品情報を取得
				taskList = dao.selectAll();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			// リクエストスコープへの属性の設定
			request.setAttribute("taskList", taskList);

			// 商品一覧画面への転送
			RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
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
