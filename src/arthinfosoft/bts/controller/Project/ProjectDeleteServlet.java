package arthinfosoft.bts.controller.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.ProjectDAO;


public class ProjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int project_id=Integer.parseInt(request.getParameter("project_id"));
		ProjectDAO dao=new ProjectDAO();
				
				boolean flag=dao.deleteData(project_id);
				if(flag){
					//System.out.println("deleted flag true");
					response.sendRedirect("ProjectListServlet");
				}
				else{
				//	System.out.println("deleted flag false");
					request.getRequestDispatcher("ProjectListServlet").forward(request, response);
				}
			}
			


	
	}


