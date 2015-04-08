package arthinfosoft.bts.controller.Employee_Detail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.EmployeeDetailDAO;

public class EmployeeDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		EmployeeDetailDAO dao = new EmployeeDetailDAO();
		boolean flag = dao.deleteData(id);
		if (flag) {
			response.sendRedirect("EmployeeDetailListServlet");
		} else {
			request.getRequestDispatcher("EmployeeDetailListServlet").forward(request,
					response);
		}

	}

}
