package arthinfosoft.bts.controller.Bug_Priority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugPriorityBean;
import arthinfosoft.bts.dao.BugPriorityDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugPriorityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String bug_priority_description = request.getParameter("bug_priority_description");

		BugPriorityBean bean = new BugPriorityBean();

		boolean isError = false;

		if (ValidationUtils.isEmpty(bug_priority_description)) {
			request.setAttribute("bug_priority_description",
					"<font color=red>*  Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("BugPriorityInsertPage.jsp").forward(
					request, response);
		} else {
			bean.setBug_priority_description(bug_priority_description);

			BugPriorityDAO dao = new BugPriorityDAO();
			boolean insertflag = dao.insertData(bean);

			if (insertflag) {
				request.getRequestDispatcher("BugPriorityListServlet").forward(
						request, response);
			} else {
				response.sendRedirect("BugPriorityInsertPage.jsp");
			}

		}
	}
}
