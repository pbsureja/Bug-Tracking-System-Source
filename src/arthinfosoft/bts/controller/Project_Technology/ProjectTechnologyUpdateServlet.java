package arthinfosoft.bts.controller.Project_Technology;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectTechnologyBean;
import arthinfosoft.bts.dao.ProjectTechnologyDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class ProjectTechnologyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String Technology_description = request
				.getParameter("projecttechnologydescription");

		ProjectTechnologyBean bean = new ProjectTechnologyBean();
		bean.setTechnology_id(id);
		bean.setTechnology_description(Technology_description);

		boolean isError = false;

		if (ValidationUtils.isEmpty(Technology_description)) {
			request.setAttribute("Technology_description",
					"<font color=red>*Is Required</font>");
			isError = true;
		}
		if(Technology_description.length()>25){
			request.setAttribute("Technology_description_length",
					"<font color=red>*Technology description should not be greater than 25</font>");
			isError = true;
			
		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ProjectTechnologyEditPage.jsp")
					.forward(request, response);

		}

		else {

			ProjectTechnologyDAO dao = new ProjectTechnologyDAO();
			boolean flag = dao.updateData(bean);
			if (flag) {
				response.sendRedirect("ProjectTechnologyListServlet");
			} else {

				response.sendRedirect("ProjectTechnologyListServlet");

			}
		}
	}
}