package arthinfosoft.bts.controller.Reporter_Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.dao.Reporter_TypeDAO;
import arthinfosoft.bts.dao.Role_EmployeeDAO;


public class Reporter_TypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Reporter_TypeBean> list = new ArrayList<Reporter_TypeBean>();
	       
		 Reporter_TypeDAO dao = new Reporter_TypeDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("Reporter_TypeList.jsp").forward(request, response);
	    	   
	       }
	}
	}


