package arthinfosoft.bts.controller.Module;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.ModuleDAO;


public class ModuleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int module_id=Integer.parseInt(request.getParameter("module_id"));
		ModuleDAO dao=new ModuleDAO();
				
				boolean flag=dao.deleteData(module_id);
				if(flag){
					//System.out.println("deleted flag true");
					response.sendRedirect("ModuleListServlet");
				}
				else{
				//	System.out.println("deleted flag false");
					request.getRequestDispatcher("ModuleListServlet").forward(request, response);
				}
			}
			


	
	}


