package arthinfosoft.bts.controller.Reporter_Type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.dao.Reporter_TypeDAO;


public class Reporter_TypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Reporter_TypeDAO dao=new Reporter_TypeDAO();
		Reporter_TypeBean bean=dao.editData(id);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("Reporter_TypeEdit.jsp").forward(request, response);
			
		
	}

}
