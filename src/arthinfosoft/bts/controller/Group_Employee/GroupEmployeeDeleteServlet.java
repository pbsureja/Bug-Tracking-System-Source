package arthinfosoft.bts.controller.Group_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.GroupEmployeeDAO;
public class GroupEmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("tid"));
		GroupEmployeeDAO dao=new GroupEmployeeDAO();
		boolean flag=dao.deleteData(id);
		if(flag){
			response.sendRedirect("GroupEmployeeListServlet");
		}
		else{
			request.getRequestDispatcher("GroupEmployeeListServlet").forward(request, response);
		
			}
	
		
	}

}
