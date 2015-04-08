package arthinfosoft.bts.controller.Module;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ModuleBean;
import arthinfosoft.bts.dao.ModuleDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class ModuleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String project_name = request.getParameter("name");
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		String status_id = request.getParameter("status_id");
		String project_id = request.getParameter("project_id");
		String estimated_start_date = request
				.getParameter("estimated_start_date");
		String estimated_end_date = request.getParameter("estimated_end_date");
		String actual_start_date = request.getParameter("actual_start_date");
		String actual_end_date = request.getParameter("actual_end_date");
		String modified_by = request.getParameter("modified_by");
		String modified_date = request.getParameter("modified_date");

		ModuleBean bean = new ModuleBean();
		Boolean isError = false;

		// project_name
		if (ValidationUtils.isEmpty(project_name)) {
			request.setAttribute("name",
					"<font color=red>Is Required </font>");
			isError = true;
		}
		if (project_name.length() > 50) {
			request.setAttribute("name_length",
					"<font color=red>length should be less than 50</font>");
			isError = true;
		}
		// code
		if (ValidationUtils.isEmpty(code)) {
			request.setAttribute("code",
					"<font color=red>Is Required </font>");
			isError = true;
		}
		if (code.length() > 5) {
			request.setAttribute("code_length",
					"<font color=red>length should be less than 5</font>");
			isError = true;
		}
		// status_id
		if (status_id.equals("")) {
			request.setAttribute("status_id",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setStatus_id(Integer.parseInt(status_id));
		}
	
		// project_id
		if (status_id.equals("")) {
			request.setAttribute("project_id",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setProject_id(Integer.parseInt(project_id));
		}
		
		// modified_by
				if (modified_by.equals("")) {
					request.setAttribute("modified_by",
							"<font color=red>Is Required </font>");
					isError = true;
				} else {
					bean.setModified_by(Integer.parseInt(modified_by));
				}

		// description
		if (ValidationUtils.isEmpty(description)) {
			request.setAttribute("description",
					"<font color=red>Is Required </font>");
			isError = true;
		}
		if (description.length() > 100) {
			request.setAttribute("description",
					"<font color=red>length should be less than 100</font>");
			isError = true;
		}
		// estimated_start_date
		if (estimated_start_date.equals("")||estimated_start_date.equals(" ")) {
			request.setAttribute("estimated_start_date",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setEstimated_start_date(estimated_start_date);
		}

		// estimated_end_date

		if (estimated_end_date.equals("")||estimated_end_date.equals(" ")) {
			request.setAttribute("estimated_end_date",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setEstimated_end_date(estimated_end_date);
		}
		// actual_start_date

		if (actual_start_date.equals("")||actual_start_date.equals(" ")) {
			request.setAttribute("actual_start_date",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setActual_start_date(actual_start_date);
		}

		// actual_end_date

		if (actual_end_date.equals("")||actual_end_date.equals(" ")) {
			request.setAttribute("actual_end_date",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setActual_end_date(actual_end_date);
		}
		
		// modified_date

		if (modified_date.equals("")||modified_date.equals(" ")) {
			request.setAttribute("modified_date",
					"<font color=red>Is Required </font>");
			isError = true;
		} else {
			bean.setModified_date(modified_date);
		}

		if (isError) {
			bean.setProject_name(project_name);
			bean.setCode(code);
			bean.setDescription(description);

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ModuleInsert.jsp").forward(
					request, response);

		} else {
			bean.setProject_name(project_name);
			bean.setCode(code);
			bean.setDescription(description);
			Boolean flag = new ModuleDAO().insert(bean);
			if (flag) {
				response.sendRedirect("ModuleListServlet");
				System.out.println("Data Inserted");
			} else {
				response.sendRedirect("ModuleListServlet");
				System.out.println("Data Not Inserted");

			}

		}

	}

}
