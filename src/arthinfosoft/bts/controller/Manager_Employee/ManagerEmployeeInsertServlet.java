package arthinfosoft.bts.controller.Manager_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.dao.ManagerEmployeeDAO;

public class ManagerEmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String employee_id = request.getParameter("employee_id");

		ManagerEmployeeBean bean = new ManagerEmployeeBean();

		bean.setEmployee_id(Integer.parseInt(employee_id));

		boolean isError = false;


		if (employee_id.equals("0")) {
			request.setAttribute("employee_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ManagerEmployeeInsertPage.jsp")
					.forward(request, response);
		} else {

			ManagerEmployeeDAO dao = new ManagerEmployeeDAO();
			boolean flag = dao.insertData(bean);

			if (flag) {
				request.getRequestDispatcher("ManagerEmployeeListServlet")
						.forward(request, response);

			} else {
				response.sendRedirect("ManagerEmployeeInsertPage.jsp");
			}
		}

	}
}
