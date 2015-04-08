package arthinfosoft.bts.controller.Role_Employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.Role_EmployeeDAO;


public class Role_EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Role_EmployeeDAO dao=new Role_EmployeeDAO();
		
		boolean flag=dao.deleteData(id);
		if(flag){
			System.out.println("deleted flag true");
			response.sendRedirect("Role_EmployeeListServlet");
		}
		else{
			System.out.println("deleted flag false");
			request.getRequestDispatcher("Role_EmployeeListServlet").forward(request, response);
		}
	}
	
	}


