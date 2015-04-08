package arthinfosoft.bts.controller.Bug_Details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.Bug_DetailsDAO;



public class Bug_DetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int snapshot_id=Integer.parseInt(request.getParameter("tid"));
		Bug_DetailsDAO dao=new Bug_DetailsDAO();
				
				boolean flag=dao.deleteData(snapshot_id);
				if(flag){
					//System.out.println("deleted flag true");
					response.sendRedirect("Bug_DetailsListServlet");
				}
				else{
				//	System.out.println("deleted flag false");
					request.getRequestDispatcher("Bug_DetailsListServlet").forward(request, response);
				}
			}
			

	
	}


