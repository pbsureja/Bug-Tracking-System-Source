package arthinfosoft.bts.controller.Bug_Priority;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import arthinfosoft.bts.bean.BugPriorityBean;
import arthinfosoft.bts.dao.BugPriorityDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugPriorityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isError=false;
		
		int id=Integer.parseInt(request.getParameter("id"));
		String bug_priority_description=request.getParameter("bugprioritydescription");
		
		
		BugPriorityBean bean=new BugPriorityBean();
		bean.setBug_priority_id(id);
		bean.setBug_priority_description(bug_priority_description);
		
		if(ValidationUtils.isEmpty(bug_priority_description)){
			request.setAttribute("bug_priority_description", "<font color=red>*Bug description should not be null</font>");
			isError=true;
		}
		
		if(bug_priority_description.length()>30){
			request.setAttribute("bug_priority_description_length", "<font color=red>*Bug description should not be greater than 30</font>");
			isError=true;
		}
		
		if(isError){
		
			request.setAttribute("bean",bean);
			request.getRequestDispatcher("BugPriorityEditPage.jsp").forward(request, response);
			
		}
		
		else{
		
		BugPriorityDAO dao=new BugPriorityDAO();
		boolean flag=dao.updateData(bean);
		
		if(flag){
			response.sendRedirect("BugPriorityListServlet");
		}
		else{
			response.sendRedirect("BugPriorityListServlet");

		}
	}

	}
}