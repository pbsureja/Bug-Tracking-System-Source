package arthinfosoft.bts.controller.Department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.DepartmentDAO;
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("tid"));
		DepartmentDAO dao=new DepartmentDAO();
		boolean flag=dao.deleteData(id);
		if(flag){
			response.sendRedirect("DepartmentListServlet");
		}
		else{
			request.getRequestDispatcher("DepartmentListServlet").forward(request, response);
		}
	}

	
	}

