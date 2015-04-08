package arthinfosoft.bts.controller.Manager_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.dao.ManagerEmployeeDAO;

public class ManagerEmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String manager_id = request.getParameter("manager_id");
		String employee_id = request.getParameter("employee_id");

		ManagerEmployeeBean bean = new ManagerEmployeeBean();
		bean.setManager_id(Integer.parseInt(manager_id));
		bean.setEmployee_id(Integer.parseInt(employee_id));

		boolean isError = false;

		// validation
		if (request.getParameter("manager_id").equals("0")) {
			request.setAttribute("manager_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}


		if (request.getParameter("employee_id").equals("0")) {
			request.setAttribute("employee_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}
		
		
		
		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ManagerEmployeeEditPage.jsp").forward(request,
					response);

		} else {
			ManagerEmployeeDAO dao = new ManagerEmployeeDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("ManagerEmployeeListServlet");
			} else {
				response.sendRedirect("ManagerEmployeeListServlet");

			}
		}

	}

}
