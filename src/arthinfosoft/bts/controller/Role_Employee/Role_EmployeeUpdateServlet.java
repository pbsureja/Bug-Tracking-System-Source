package arthinfosoft.bts.controller.Role_Employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.dao.Role_EmployeeDAO;
import arthinfosoft.bts.util.ValidationUtils;


public class Role_EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("Role_id"));
		String Role_Description=request.getParameter("Role_Description");
		
		
		Role_EmployeeBean bean=new Role_EmployeeBean();
		
		
		bean.setRole_id(id);
		bean.setRoll_Description(Role_Description);
		

boolean isError=false;	
	if(ValidationUtils.isEmpty(Role_Description)){
			request.setAttribute("Role_Description1", "<font color=red>*Is Required</font>");
			isError=true;
		}
	if(Role_Description.length()>25){
		request.setAttribute("Role_DescriptionLength", "<font color=red>*Role description should be less than 25</font>");
		isError=true;
	}
		
		
		if(isError){
		
			request.setAttribute("bean",bean);
			request.getRequestDispatcher("Role_EmployeeEdit.jsp").forward(request, response);
			
		}
		
		else{
	
		
		Role_EmployeeDAO dao=new Role_EmployeeDAO();
		boolean flag=dao.updateData(bean);
		
		if(flag){
			response.sendRedirect("Role_EmployeeListServlet");
		}
		else{
			response.sendRedirect("Role_EmployeeListServlet");

		}
	

	}

	}
}