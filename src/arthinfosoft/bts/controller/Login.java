package arthinfosoft.bts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.dao.LoginDAO;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email=request.getParameter("id");
	String password=request.getParameter("password");
	String type=request.getParameter("type");
	HttpSession session = request.getSession();
	if(type.equals("Administrator")){
		EmployeeDetailBean bean=null;
		bean=new LoginDAO().AutheticateAdmin(email, password, type);
		if(bean!=null){
			session.setAttribute("beana", bean);
			session.setAttribute("type", type);
			request.getRequestDispatcher("AdminMainPage.jsp").forward(
					request, response);
			
		}else{
			request.setAttribute("error",
					"<font color=red>Wrong Administrator Creditianls </font>");
			request.getRequestDispatcher("Login.jsp").forward(
					request, response);
		}
		
		
	}else if(type.equals("Client")){
		Client_DetailsBean bean=null;
		bean=new LoginDAO().AutheticateClient(email, password, type);
if(bean!=null){
	System.out.println("Login");
	session.setAttribute("beanc", bean);
	session.setAttribute("type", type);
	request.getRequestDispatcher("ClientMainPage.jsp").forward(
			request, response);
	
		}else{
			
			request.setAttribute("error",
					"<font color=red>Wrong Client Creditianls </font>");
			request.getRequestDispatcher("Login.jsp").forward(
					request, response);
		}
	}else if(type.equals("Employee")){
		EmployeeDetailBean bean=null;
	LoginDAO dao=new LoginDAO();
	bean=dao.AutheticateEmployee(email, password, type);
	if(bean!=null){
		System.out.println("Login");
		session.setAttribute("beane", bean);
		session.setAttribute("type", type);
		request.getRequestDispatcher("EmployeeMainPage.jsp").forward(
				request, response);
		
	}else{
		request.setAttribute("error",
				"<font color=red>Wrong Employee Creditianls </font>");
		request.getRequestDispatcher("Login.jsp").forward(
				request, response);
	}
	}
	
	}

}
