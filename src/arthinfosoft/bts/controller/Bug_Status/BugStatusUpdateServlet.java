package arthinfosoft.bts.controller.Bug_Status;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugStatusBean;
import arthinfosoft.bts.dao.BugStatusDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String bug_status_description = request
				.getParameter("bugstatusdescription");

		BugStatusBean bean = new BugStatusBean();
		bean.setBug_status_id(id);
		bean.setBug_status_description(bug_status_description);

		boolean isError=false;
		
		if (ValidationUtils.isEmpty(bug_status_description)) {
			request.setAttribute("bug_status_description",
					"<font color=red>*Bug status description should not be null</font>");
			isError = true;
		}

	
		if(bug_status_description.length()>30)
		{
			request.setAttribute("bug_status_description_length",
					"<font color=red>*Bug status description should not be greater than 30</font>");
			isError = true;	
		}
		
		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BugStatusEditPage.jsp").forward(
					request, response);

		}

		else {

			BugStatusDAO dao = new BugStatusDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("BugStatusListServlet");
			} else {
				response.sendRedirect("BugStatusListServlet");

			}
		}

	}
}