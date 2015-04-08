package arthinfosoft.bts.controller.Group_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupEmployeeBean;
import arthinfosoft.bts.dao.GroupEmployeeDAO;

public class GroupEmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String group_id = request.getParameter("group_id");
		String employee_id = request.getParameter("employee_id");
String id=request.getParameter("tid");
		GroupEmployeeBean bean = new GroupEmployeeBean();
		bean.setGroup_id(Integer.parseInt(group_id));
		bean.setEmployee_id(Integer.parseInt(employee_id));

		boolean isError = false;

		// validation
		if (request.getParameter("group_id").equals("0")) {
			request.setAttribute("group_id",
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
			request.getRequestDispatcher("GroupEmployeeEditPage.jsp").forward(request,
					response);

		} else {
			GroupEmployeeDAO dao = new GroupEmployeeDAO();
			boolean flag = dao.updateData(bean,Integer.parseInt(id));

			if (flag) {
				response.sendRedirect("GroupEmployeeListServlet");
			} else {
				response.sendRedirect("GroupEmployeeListServlet");

			}
		}

	}

}
