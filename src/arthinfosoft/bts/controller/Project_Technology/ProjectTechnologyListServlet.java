package arthinfosoft.bts.controller.Project_Technology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectTechnologyBean;
import arthinfosoft.bts.dao.ProjectTechnologyDAO;

public class ProjectTechnologyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<ProjectTechnologyBean> list = new ArrayList<ProjectTechnologyBean>();
		ProjectTechnologyDAO dao = new ProjectTechnologyDAO();
		list = dao.listData();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectTechnologyListPage.jsp")
					.forward(request, response);
		}

	}
}
