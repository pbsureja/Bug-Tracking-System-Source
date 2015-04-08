package arthinfosoft.bts.controller.Project_Platform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.dao.ProjectPlatformDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class ProjectPlatformInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Platform_description = request
				.getParameter("Platform_description");

		boolean isError = false;

		if (ValidationUtils.isEmpty(Platform_description)) {
			request.setAttribute("Platform_description",
					"<font color=red>*Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("ProjectPlatformInsertPage.jsp").forward(
					request, response);
		} else {

			ProjectPlatformBean bean = new ProjectPlatformBean();
			bean.setPlatform_description(Platform_description);

			ProjectPlatformDAO dao = new ProjectPlatformDAO();
			boolean flag = dao.insertData(bean);
			if (flag) {
				request.getRequestDispatcher("ProjectPlatformListServlet")
						.forward(request, response);

			} else {
				response.sendRedirect("ProjectPlatformInsertPage.jsp");
			}

		}

	}
}