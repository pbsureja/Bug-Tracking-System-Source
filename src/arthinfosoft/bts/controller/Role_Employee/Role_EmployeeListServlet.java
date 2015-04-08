package arthinfosoft.bts.controller.Role_Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.dao.Role_EmployeeDAO;


public class Role_EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    List<Role_EmployeeBean> list = new ArrayList<Role_EmployeeBean>();
	       
	       Role_EmployeeDAO dao = new Role_EmployeeDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("Role_EmployeeListPage.jsp").forward(request, response);
	    	   
	       }
	}
	}


