package arthinfosoft.bts.controller.Role_Employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.dao.Role_EmployeeDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class Role_EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String Role_Description=request.getParameter("Role_Description");
	Role_EmployeeBean bean=new Role_EmployeeBean();
	Boolean isError=false;
	if(ValidationUtils.isEmpty(Role_Description)){
		request.setAttribute("Role_Description", "<font color=red>Is Required </font>");
		isError = true;
	}
	
	if(Role_Description.length()>25){
		request.setAttribute("Role_DescriptionLength", "<font color=red>Size Should be less than 25</font>");
		isError = true;
	}
	
	if(isError){
		request.getRequestDispatcher("Role_EmployeeInsert.jsp").forward(request, response);
	}
	else{
	
	bean.setRoll_Description(Role_Description);
    Role_EmployeeDAO dao=new Role_EmployeeDAO();
    boolean flag=dao.insertRole_Employee(bean);
    if(flag){
    	response.sendRedirect("Role_EmployeeListServlet");
    	System.out.println("Data Inserted");
    }else{
    	response.sendRedirect("Role_EmployeeListServlet");
    	System.out.println("Data Not Inserted");
    }
	}
	}

}
