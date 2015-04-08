package arthinfosoft.bts.controller.Bug_Type;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.BugTypeDAO;

public class BugTypeDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("tid"));
		BugTypeDAO dao=new BugTypeDAO();
		System.out.println(id);
		boolean flag=dao.deleteData(id);
		if(flag){
			System.out.println("deleted flag true");
			response.sendRedirect("BugTypeListServlet");
		}
		else{
			System.out.println("deleted flag false");
			request.getRequestDispatcher("BugTypeListServlet").forward(request, response);
		}
	}

}
