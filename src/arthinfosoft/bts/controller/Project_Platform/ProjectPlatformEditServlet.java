package arthinfosoft.bts.controller.Project_Platform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.dao.ProjectPlatformDAO;

public class ProjectPlatformEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		ProjectPlatformDAO dao = new ProjectPlatformDAO();
		ProjectPlatformBean bean = dao.editData(id);

		if (bean != null) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ProjectPlatformEditPage.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("ProjectPlatformListServlet");
		}
	}

}
