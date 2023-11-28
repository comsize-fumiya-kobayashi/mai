package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;

@WebServlet(name = "task-delete-servlet", urlPatterns = { "/task-delete-servlet" })
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TaskDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
				request.setCharacterEncoding("UTF-8");
				
				DeleteDAO dao = new DeleteDAO();
				
				int processingNumber = 0; //処理件数
				
				try {
					
					processingNumber = dao.deleteTask(Integer.parseInt(request.getParameter("user_id")));
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				// 処理件数をリクエストスコープに設定
				request.setAttribute("processingNumber", processingNumber);
				// 削除結果画面に遷移
				RequestDispatcher rd = request.getRequestDispatcher("DeleteConfirm.jsp");
				rd.forward(request, response);
					
	}

}
