package arthinfosoft.bts.controller.Reporter_Type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.Reporter_TypeDAO;
import arthinfosoft.bts.dao.Role_EmployeeDAO;


public class Reporter_TypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
Reporter_TypeDAO dao=new Reporter_TypeDAO();
		
		boolean flag=dao.deleteData(id);
		if(flag){
			//System.out.println("deleted flag true");
			response.sendRedirect("Reporter_TypeListServlet");
		}
		else{
		//	System.out.println("deleted flag false");
			request.getRequestDispatcher("Reporter_TypeListServlet").forward(request, response);
		}
	}
	
	}

