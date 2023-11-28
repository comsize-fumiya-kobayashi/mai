package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.UpdateBean;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/update-confirm-servlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		// Beanをインスタンス化
		UpdateBean updateTask = new UpdateBean();
		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] selectCategory = request.getParameter("selectCategory").split(",");
		String[] LimitName = request.getParameter("limitName").split(",");


		// 変更情報をbeanにセット
		updateTask.setTaskName("task_name");
		updateTask.setCategoryName("category_name");
		updateTask.setLimitDate(Integer.parseInt(request.getParameter("limit_Date")));
		updateTask.setUserName("user_name");
		updateTask.setStatusName("status_name");
		updateTask.setMemo("memo");
		
		// リクエストスコープにbeanの情報を設定
		request.setAttribute("updateTask", updateTask);
		// 変更情報確認画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("UpdateConfirm.jsp");
		rd.forward(request, response);
	}
	

}
