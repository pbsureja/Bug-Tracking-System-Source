package arthinfosoft.bts.controller.Bug_Type;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugTypeBean;
import arthinfosoft.bts.dao.BugTypeDAO;

public class BugTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		BugTypeDAO dao = new BugTypeDAO();
		BugTypeBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BugTypeEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("BugTypeListServlet");
		}
	}
}
