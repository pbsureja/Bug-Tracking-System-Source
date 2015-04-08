package arthinfosoft.bts.controller.Bug_Type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugTypeBean;
import arthinfosoft.bts.dao.BugTypeDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bug_type_description = request.getParameter("bug_type_description");

		boolean isError = false;

		if (ValidationUtils.isEmpty(bug_type_description)) {
			request.setAttribute("bug_type_description",
					"<font color=red>* bug type description  Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("BugTypeInsertPage.jsp").forward(
					request, response);
		} else {


		BugTypeBean bean = new BugTypeBean();

		bean.setBug_type_description(bug_type_description);

		BugTypeDAO dao = new BugTypeDAO();
		boolean insertflag = dao.insertData(bean);

		if (insertflag) {
			request.getRequestDispatcher("BugTypeListServlet").forward(
					request, response);
		} else {
			response.sendRedirect("BugTypeInsertPage.jsp");
		}

	}

}
}