package arthinfosoft.bts.controller.Client_Details;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.Client_DetailsDAO;
import arthinfosoft.bts.dao.Reporter_TypeDAO;

/**
 * Servlet implementation class Client_DetailsDeleteServlet
 */
public class Client_DetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Client_DetailsDAO dao=new Client_DetailsDAO();
				
				boolean flag=dao.deleteData(id);
				if(flag){
					//System.out.println("deleted flag true");
					response.sendRedirect("Client_DetailsListServlet");
				}
				else{
				//	System.out.println("deleted flag false");
					request.getRequestDispatcher("Client_DetailsListServlet").forward(request, response);
				}
			}
	}


