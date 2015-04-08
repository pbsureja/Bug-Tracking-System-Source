package arthinfosoft.bts.controller.Module;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ModuleBean;
import arthinfosoft.bts.dao.ModuleDAO;
public class ModuleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String module_id=request.getParameter("module_id");
		
		ModuleDAO dao=new ModuleDAO();
		ModuleBean bean=dao.editData(module_id);
		if(bean!=null){
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("ModuleEdit.jsp").forward(request, response);
		}
		else{
			
			System.out.println("Bean is null");
			
		}
		
	}
}