package arthinfosoft.bts.controller.Project_Technology;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.ProjectTechnologyDAO;

public class ProjectTechnologyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		ProjectTechnologyDAO dao=new ProjectTechnologyDAO();
		boolean flag=dao.deleteData(id);
		if(flag){
			response.sendRedirect("ProjectTechnologyListServlet");
		}
		else{
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);
		}
	}
}
