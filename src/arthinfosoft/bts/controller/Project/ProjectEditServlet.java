package arthinfosoft.bts.controller.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectBean;
import arthinfosoft.bts.dao.ProjectDAO;
public class ProjectEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String project_id=request.getParameter("project_id");
		ProjectDAO dao=new ProjectDAO();
		ProjectBean bean=dao.editData(project_id);
		if(bean!=null){
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("ProjectEdit.jsp").forward(request, response);
		}
		else{
			
			System.out.println("Bean is null");
			
		}
		
	}
}