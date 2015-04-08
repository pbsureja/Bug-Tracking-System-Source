package arthinfosoft.bts.controller.Employee_Detail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.dao.EmployeeDetailDAO;

public class EmployeeDetailEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("tid"));
		EmployeeDetailDAO dao = new EmployeeDetailDAO();
		EmployeeDetailBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("EmployeeDetailEditPage.jsp").forward(request,
					response);

		} else {
			request.getRequestDispatcher("EmployeeDetailListServlet");
		}

	}

}
