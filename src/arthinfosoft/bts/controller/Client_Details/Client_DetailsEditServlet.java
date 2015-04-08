package arthinfosoft.bts.controller.Client_Details;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.dao.Client_DetailsDAO;
import arthinfosoft.bts.dao.Reporter_TypeDAO;


public class Client_DetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Client_DetailsDAO dao=new Client_DetailsDAO();
		Client_DetailsBean bean=dao.editData(id);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("Client_DetailsEdit.jsp").forward(request, response);
	}

}
