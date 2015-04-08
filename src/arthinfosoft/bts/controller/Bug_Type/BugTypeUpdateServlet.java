package arthinfosoft.bts.controller.Bug_Type;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import arthinfosoft.bts.bean.BugTypeBean;
import arthinfosoft.bts.dao.BugTypeDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class BugTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String bug_type_description=request.getParameter("bugeditdescription");
		
		BugTypeBean bean=new BugTypeBean();
		bean.setBug_type_id(id);
		bean.setBug_type_description(bug_type_description);
		
		boolean isError=false;
		
		if (ValidationUtils.isEmpty(bug_type_description)) {
			request.setAttribute("bug_type_description",
					"<font color=red>*Bug type description should not be null</font>");
			isError = true;
		}
		if(bug_type_description.length()>30){
			request.setAttribute("bug_type_description_length",
					"<font color=red>*Bug type description should not be greater than 30</font>");
			isError = true;
			
		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BugTypeEditPage.jsp").forward(
					request, response);

		}

		else {

		
		BugTypeDAO dao=new BugTypeDAO();
		boolean flag=dao.updateData(bean);
		
		if(flag){
			response.sendRedirect("BugTypeListServlet");
		}
		else{
			response.sendRedirect("BugTypeListServlet");

		}
	}

}
}