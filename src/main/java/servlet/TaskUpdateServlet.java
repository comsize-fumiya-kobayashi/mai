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

import model.dao.UpdateDAO;
import model.entity.UpdateBean;


@WebServlet("/task-update-servlet")
public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TaskUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		UpdateDAO dao = new UpdateDAO();
		UpdateBean updateTask = new UpdateBean();
		
		int processingNumber = 0;
		
		// 変更情報をbeanにセット
				updateTask.setTaskName(request.getParameter("task_name"));
				updateTask.setCategoryName(request.getParameter("category_name"));
				updateTask.setLimitDate(Integer.parseInt(request.getParameter("limit_date")));
				updateTask.setUserName(request.getParameter("user_name"));
				updateTask.setMemo(request.getParameter("memo"));
				updateTask.setStatusName(request.getParameter("status_name"));
				
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
				session.removeAttribute("updateTask");
				// 変更結果画面に遷移
				RequestDispatcher rd = request.getRequestDispatcher("UpdateComplete.jsp");
				rd.forward(request, response);
			}
		

}
