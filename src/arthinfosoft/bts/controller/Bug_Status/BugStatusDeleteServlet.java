package arthinfosoft.bts.controller.Bug_Status;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.BugStatusDAO;

public class BugStatusDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("tid"));
		BugStatusDAO dao=new BugStatusDAO();
		System.out.println(id);
		boolean flag=dao.deleteData(id);
		if(flag){
			System.out.println("deleted flag true");
			response.sendRedirect("BugStatusListServlet");
		}
		else{
			System.out.println("deleted flag false");
			request.getRequestDispatcher("BugStatusListServlet").forward(request, response);
		}
	}

}
