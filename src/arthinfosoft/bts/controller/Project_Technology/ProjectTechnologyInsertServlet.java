package arthinfosoft.bts.controller.Project_Technology;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectTechnologyBean;
import arthinfosoft.bts.dao.ProjectTechnologyDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class ProjectTechnologyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Technology_description = request
				.getParameter("Technology_description");
		
		boolean isError = false;

		if (ValidationUtils.isEmpty(Technology_description)) {
			request.setAttribute("Technology_description",
					"<font color=red>*Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("ProjectTechnologyInsertPage.jsp").forward(
					request, response);
		} else {

		
		ProjectTechnologyBean bean = new ProjectTechnologyBean();
		bean.setTechnology_description(Technology_description);

		ProjectTechnologyDAO dao = new ProjectTechnologyDAO();
		boolean flag = dao.insertData(bean);
		if (flag) {
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);

		} else {
			response.sendRedirect("ProjectTechnologyInsertPage.jsp");
		}

	}

}
}