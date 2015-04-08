package arthinfosoft.bts.controller.Pmt_Status;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.PmtStatusDAO;


public class PmtStatusDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		PmtStatusDAO dao=new PmtStatusDAO();
		System.out.println(id);
		boolean flag=dao.deleteData(id);
		if(flag){
			response.sendRedirect("PmtStatusListServlet");
		}
		else{
			request.getRequestDispatcher("PmtStatusListServlet").forward(request, response);
		}
	}

}
