package arthinfosoft.bts.controller.Reporter_Type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.dao.Reporter_TypeDAO;
import arthinfosoft.bts.dao.Role_EmployeeDAO;
import arthinfosoft.bts.util.ValidationUtils;


public class Reporter_TypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reporter_type_name=request.getParameter("reporter_type_name");
		Reporter_TypeBean bean=new Reporter_TypeBean();
		Boolean isError=false;
		if(ValidationUtils.isEmpty(reporter_type_name)){
			request.setAttribute("reporter_type_name", "<font color=red>Is Required </font>");
			isError = true;
		}
		
		if(reporter_type_name.length()>20){
			request.setAttribute("reporter_type_namelength", "<font color=red>Size Should be less than 20</font>");
			isError = true;
		}
		
		if(isError){
			request.getRequestDispatcher("Reporter_TypeInsert.jsp").forward(request, response);
		}
		else{
		
		bean.setReporter_type_name(reporter_type_name);
		Reporter_TypeDAO dao=new Reporter_TypeDAO();
	    boolean flag=dao.insertReporter_Type(bean);
	    if(flag){
	    	response.sendRedirect("Reporter_TypeIndex.html");
	    	System.out.println("Data Inserted");
	    }else{
	    	response.sendRedirect("Reporter_TypeIndex.html");
	    	System.out.println("Data Not Inserted");
	    }
		}
		}

	
	}


