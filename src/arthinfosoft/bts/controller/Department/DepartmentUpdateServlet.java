package arthinfosoft.bts.controller.Department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.DepartmentBean;
import arthinfosoft.bts.dao.DepartmentDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class DepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int department_id = Integer.parseInt(request.getParameter("id"));
		String department_description = request.getParameter("department_description");
		String max_limit = request.getParameter("max_limit");
		String manager_id = request.getParameter("manager_id");

		DepartmentBean bean = new DepartmentBean();
		bean.setDepartment_id(department_id);
		bean.setDepartment_description(department_description);
		bean.setManager_id(Integer.parseInt(manager_id));
		bean.setMax_limit(0);

		boolean isError = false;

		// validation
		if (request.getParameter("manager_id").equals("0")) {
			request.setAttribute("manager_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		if (ValidationUtils.isEmpty(department_description)) {
			request.setAttribute("department_description_empty",
					"<font color=red>* department description cannot be null.</font>");
			isError = true;
		}

		if (department_description.length() > 20) {
			request.setAttribute(
					"department_description_length",
					"<font color=red>* department description cannot be greater than 20 characters.</font>");
			isError = true;

		}

		if (ValidationUtils.isEmpty(request.getParameter("max_limit"))) {
			request.setAttribute("max_limit_empty",
					"<font color=red>* Max limit cannot be null. </font>");
			isError = true;
		}

		String numToken = "[\\p{Digit}&&[0123456789]]+";
		if (max_limit.matches(numToken)) {
			if (max_limit.length() <= 3) {
				if (Integer.parseInt(max_limit) > 999) {
					request.setAttribute("max_limit_length",
							"<font color=red>* Max limit cannot be greater than 999.</font>");
					isError = true;

				} else if (Integer.parseInt(max_limit) < 999)
					bean.setMax_limit(Integer.parseInt(max_limit));
			} else {
				request.setAttribute("max_limit_length",
						"<font color=red>* Max limit cannot be greater than 999.</font>");
				isError = true;

			}
		} else {
			request.setAttribute("max_limit_empty",
					"<font color=red>* Max limit should be numbers only.</font>");
			isError = true;

		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("DepartmentEditPage.jsp").forward(request,
					response);

		} else {
			DepartmentDAO dao = new DepartmentDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("DepartmentListServlet");
			} else {
				response.sendRedirect("DepartmentListServlet");

			}
		}

	}
}
