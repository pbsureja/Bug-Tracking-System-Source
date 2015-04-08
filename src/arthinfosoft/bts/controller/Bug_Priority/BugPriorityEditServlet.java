package arthinfosoft.bts.controller.Bug_Priority;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugPriorityBean;
import arthinfosoft.bts.dao.BugPriorityDAO;

public class BugPriorityEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		int id = Integer.parseInt(request.getParameter("tid"));
		
		
		BugPriorityDAO dao = new BugPriorityDAO();
		BugPriorityBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BugPriorityEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("BugPriorityListServlet");
		}
	}
}
