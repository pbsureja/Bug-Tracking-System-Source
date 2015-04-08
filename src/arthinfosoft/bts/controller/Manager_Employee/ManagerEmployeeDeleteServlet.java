package arthinfosoft.bts.controller.Manager_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.ManagerEmployeeDAO;
public class ManagerEmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("tid"));
		ManagerEmployeeDAO dao=new ManagerEmployeeDAO();
		boolean flag=dao.deleteData(id);
		if(flag){
			response.sendRedirect("ManagerEmployeeListServlet");
		}
		else{
			request.getRequestDispatcher("ManagerEmployeeListServlet").forward(request, response);
		
			}
	
		
	}

}
