package arthinfosoft.bts.controller.Bug_Details;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Bug_DetailsBean;
import arthinfosoft.bts.dao.Bug_DetailsDAO;


public class Bug_DetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Bug_DetailsDAO dao=new Bug_DetailsDAO();
		Bug_DetailsBean bean=dao.editData(id);
		if(bean!=null){
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("Bug_DetailsEdit.jsp").forward(request, response);
		}
		else{
			
			System.out.println("Bean is null");
			
		}
		
	}

}
