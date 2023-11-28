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
import javax.servlet.http.HttpSession;

import model.dao.UpdateDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;


@WebServlet("/update-detail-servlet")
public class UpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			request.setCharacterEncoding("UTF-8");

			UpdateDAO dao = new UpdateDAO();
			List<CategoryBean> categoryList = null;
			List<StatusBean> statusList = null;

			// 選択した商品の商品コード取得
			String taskName = (request.getParameter("task_name"));
			String categoryName = (request.getParameter("category_name"));
			String statusName = (request.getParameter("status_name"));

			try {
				updateDetail = dao.selectTaskName(taskName);
				categoryList = dao.selectCategory(categoryName);
				statusList = dao.selectStatus(statusName);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			// セッションオブジェクトの取得
			HttpSession session = request.getSession();
			// 商品の詳細情報をセッションに設定
			session.setAttribute("updateDetail", updateDetail);
		
			session.setAttribute("categoryList", categoryList);
			
			session.setAttribute("statusList", statusList);
			// 商品詳細画面に遷移
			RequestDispatcher rd = request.getRequestDispatcher("item-detail.jsp");
			rd.forward(request, response);
		
		
	}

}
