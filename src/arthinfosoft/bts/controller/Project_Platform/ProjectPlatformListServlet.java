package arthinfosoft.bts.controller.Project_Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.dao.ProjectPlatformDAO;

public class ProjectPlatformListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<ProjectPlatformBean> list = new ArrayList<ProjectPlatformBean>();
		ProjectPlatformDAO dao = new ProjectPlatformDAO();
		list = dao.listData();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectPlatformListPage.jsp")
					.forward(request, response);
		}

	}

}
