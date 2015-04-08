package arthinfosoft.bts.controller.Reporter_Type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.dao.Reporter_TypeDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class Reporter_TypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("reporter_type_id"));
		String reporter_type_name = request.getParameter("reporter_type_name");

		Reporter_TypeBean bean = new Reporter_TypeBean();
		bean.setReporter_type_id(id);
		bean.setReporter_type_name(reporter_type_name);

		boolean isError=false;	
		if(ValidationUtils.isEmpty(reporter_type_name)){
				request.setAttribute("reporter_type_name", "<font color=red>*Is Required</font>");
				isError=true;
			}
		if(reporter_type_name.length()>20){
			request.setAttribute("reporter_type_nameLength", "<font color=red>*reporter_type_name should be less than 20</font>");
			isError=true;
		}
			
			
			if(isError){
			
				request.setAttribute("bean",bean);
				request.getRequestDispatcher("Reporter_TypeEdit.jsp").forward(request, response);
				
			}
			
			else{
		
		

		Reporter_TypeDAO dao = new Reporter_TypeDAO();
		boolean flag = dao.updateData(bean);

		if (flag) {
			response.sendRedirect("Reporter_TypeListServlet");
		} else {
			response.sendRedirect("Reporter_TypeListServlet");

		}

	}
}
}