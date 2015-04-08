package arthinfosoft.bts.controller.Bug_Status;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugStatusBean;
import arthinfosoft.bts.dao.BugStatusDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugStatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bug_status_description = request.getParameter("bug_status_description");
		

		boolean isError = false;

		if (ValidationUtils.isEmpty(bug_status_description)) {
			request.setAttribute("bug_status_description",
					"<font color=red>* bug status description  Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("BugStatusInsertPage.jsp").forward(
					request, response);
		} else {


		BugStatusBean bean = new BugStatusBean();

		bean.setBug_status_description(bug_status_description);

		BugStatusDAO dao = new BugStatusDAO();
		boolean insertflag = dao.insertData(bean);

		if (insertflag) {
			request.getRequestDispatcher("BugStatusListServlet").forward(
					request, response);
		} else {
			response.sendRedirect("BugStatusInsertPage.jsp");
		}

	}

}

}